package br.com.is.DAO;

import static br.com.is.View.Login.usuarioLogado;
import static br.com.is.View.Login.permissoes;

import br.com.is.utils.HibernateUtil;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 * @author Portella, Rodolfo <rodolfosportella@gmail.com>
 * @param <T>
 */
public class GenericoDAO<T> {

    public Object obj;
    public Session s;

    public GenericoDAO(Object obj) {
        s = HibernateUtil.getSession();
        s.beginTransaction();
        this.obj = obj;
    }

    public String gravar() {

        try {
            String iduser = String.valueOf(usuarioLogado.getPessoa1().getCodigo());
            SQLQuery query = s.createSQLQuery("set session \"iip.userid\" = " + iduser + "");
            query.executeUpdate();
            
            SQLQuery queryAudit = s.createSQLQuery("set session \"iip.auditoria\" = \"ON\"");
            queryAudit.executeUpdate();

            s.saveOrUpdate(this.obj);
            s.getTransaction().commit();
            return "Gravado com sucesso!";
        } catch (Exception e) {
            s.getTransaction().rollback();
            System.out.println("Erro ao gravar: " + e.getMessage());
            return "Houve algum problema para gravado!";
        } finally {
            s.close();
        }
    }

    public String excluir() {
        try {
            s.delete(this.obj);
            s.getTransaction().commit();
            return "Excluido com sucesso!";
        } catch (Exception e) {
            s.getTransaction().rollback();
            System.out.println("Erro ao excluir: " + e.getMessage());
            return "Houve algum problema para excluir!";
        } finally {
            s.close();
        }
    }

    public T visualizar(String[][] criterios) {
        try {
            Criteria criteria = s.createCriteria(this.obj.getClass());
            if (criterios != null) {
                for (String[] criterio : criterios) {
                    criteria.add(Restrictions.eq(criterio[0], ((criterio[1].matches("^[0-9]*$")) ? Integer.valueOf(criterio[1]) : criterio[1])));
                }
            }
            return (T) criteria.uniqueResult();
        } catch (Exception e) {
            s.getTransaction().rollback();
            System.out.println("Erro ao visualizar: " + e.getMessage());
            return null;
        } finally {
            s.close();
        }
    }

    /* Regras de uso
     * Vetor de 3 posições
     * 1 - Tipo de consulta 
     * 2 - Onde consultar na tabela 
     * 3 - Dado a ser procurado
     *
     * Tipos de consultas
     *
     * contain - Verifica com a clausula LIKE [contain, coluna, %valor%]
     * equal - Verifica igualdade [equal, coluna, valor]
     * node - Cria Alias entre tabalas [node, tabela, nomenclatura]
     * order - Ordena os elementos conforme o solicitaddo [order, coluna, asc/desc]
     */
    public List Listar(String[][] criterios) {
        try {
            Criteria criteria = s.createCriteria(this.obj.getClass());
            if (criterios != null) {
                for (String[] criterio : criterios) {
                    if (criterio[0].equals("contain")) {
                        criteria.add(Restrictions.like(criterio[1], criterio[2]).ignoreCase());
                    } else if ("equal".equals(criterio[0])) {
                        criteria.add(Restrictions.eq(criterio[1], ((criterio[2].matches("^[0-9]*$")) ? Integer.valueOf(criterio[2]) : criterio[2])));
                    } else if ("node".equals(criterio[0])) {
                        criteria.createAlias(criterio[1], criterio[2]);
                    } else if ("order".equals(criterio[0])) {

                    }
                }
            }
            return criteria.list();
        } catch (Exception e) {
            s.getTransaction().rollback();
            System.out.println("Erro ao listar composta: " + e.getMessage());
            return null;
        } finally {
            s.close();
        }
    }

    public int ProximoCodigo() {
        try {
            return (int) s.createCriteria(this.obj.getClass())
                    .setProjection(Projections.max("codigo"))
                    .uniqueResult() + 1;
        } catch (Exception e) {
            s.getTransaction().rollback();
            System.out.println("Erro ao listar tudo: " + e.getMessage());
            return 1;
        } finally {
            s.close();
        }
    }

}
