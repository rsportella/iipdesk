package br.com.is.DAO;

import br.com.is.utils.HibernateUtil;
import static com.sun.javafx.util.Utils.split;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 * @author Portella, Rodolfo <rodolfosportella@gmail.com>
 * @param <T>
 */
public class Generico<T> {

    public Object obj;
    public Session s;

    public Generico(Object obj) {
        s = HibernateUtil.getSession();
        s.beginTransaction();
        this.obj = obj;
    }

    public boolean Gravar() {
        try {
            s.saveOrUpdate(this.obj);
            s.getTransaction().commit();
            return true;
        } catch (Exception e) {
            s.getTransaction().rollback();
            System.out.println("Erro ao gravar: " + e.getMessage());
            return false;
        } finally {
            s.close();
        }
    }

    public boolean Excluir() {
        try {
            s.delete(this.obj);
            s.getTransaction().commit();
            return true;
        } catch (Exception e) {
            s.getTransaction().rollback();
            System.out.println("Erro ao excluir: " + e.getMessage());
            return false;
        } finally {
            s.close();
        }
    }

    public T Visualizar(List<QueryCriteria> criterias) {
        try {
            return (T) GenerateCriteria(criterias).uniqueResult();
        } catch (Exception e) {
            s.getTransaction().rollback();
            System.out.println("Erro ao visualizar: " + e.getMessage());
            return null;
        } finally {
            s.close();
        }
    }

    public List Listar(List<QueryCriteria> criterias) {
        try {
            return GenerateCriteria(criterias).list();
        } catch (Exception e) {
            s.getTransaction().rollback();
            System.out.println("Erro ao listar composta: " + e.getMessage());
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
    private Criteria GenerateCriteria(List<QueryCriteria> criterias) {
        Criteria queryRule = s.createCriteria(this.obj.getClass());
        if (criterias != null) {
            for (QueryCriteria criteria : criterias) {
                switch (criteria.getWithwhat()) {
                    case "contain":
                        queryRule.add(Restrictions.like(
                                criteria.getWhere(), criteria.getWhat()).ignoreCase());
                        break;
                    case "equal":
                        boolean isNumber = false;
                        if (criteria.getWhere().indexOf(".") >= 0) {
                            String[] codigo = split(criteria.getWhere(), ".");
                            if (codigo[1].equals("codigo")) {
                                isNumber = true;
                            }
                        }
                        if (criteria.getWhere().contains("codigo") || isNumber) {
                            queryRule.add(Restrictions.eq(criteria.getWhere(),
                                    Integer.valueOf(criteria.getWhat())));
                        } else {
                            queryRule.add(Restrictions.eq(criteria.getWhere(),
                                    criteria.getWhat()));
                        }
                        break;
                    case "node":
                        queryRule.createAlias(criteria.getWhere(), criteria.getWhat());
                        break;
                    case "order":
                        break;
                }
            }
        }

        return queryRule;
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
