package prototype;

import java.io.Serializable;

/**
 * @program: design-patterns
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-10 11:03
 **/

public class WorkExperience1 implements Serializable,Cloneable   {
    public static final long serialVersionUID=1L;
    private String workDate;
    private String WorkCompany;

    public String getWorkDate() {
        return workDate;
    }

    public String getWorkCompany() {
        return WorkCompany;
    }

    public WorkExperience1 setWorkCompany(String workCompany) {
        WorkCompany = workCompany;
        return this;
    }

    public WorkExperience1 setWorkDate(String workDate) {
        this.workDate = workDate;
        return this;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
