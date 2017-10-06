package br.com.is.DAO;

/**
 * @author Portella, Rodolfo <rodolfosportella@gmail.com>
 */
public class QueryCriteria {

    /*Com o que?*/
    private String withwhat;
    /*Aonde*/
    private String where;
    /*O que?*/
    private String what;

    public QueryCriteria(String withwhat, String where, String what) {
        this.withwhat = withwhat;
        this.where = where;
        this.what = what;
    }

    public String getWithwhat() {
        return withwhat;
    }

    public void setWithwhat(String withwhat) {
        this.withwhat = withwhat;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public String getWhat() {
        return what;
    }

    public void setWhat(String what) {
        this.what = what;
    }

}
