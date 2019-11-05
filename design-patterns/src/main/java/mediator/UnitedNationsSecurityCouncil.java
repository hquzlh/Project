package mediator;

/**
 * @program: design-patterns
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-12 10:05
 **/

public class UnitedNationsSecurityCouncil extends UnitedNations {
     private USA usa;
    private Iraq iraq;
    @Override
    public void Declare(String message, Country colleague) {
        if(colleague ==usa){
            iraq.getMessage(message);
        }else {
            usa.getMessage(message);
        }
    }

    public USA getUsa() {
        return usa;
    }

    public void setUsa(USA usa) {
        this.usa = usa;
    }

    public Iraq getIraq() {
        return iraq;
    }

    public void setIraq(Iraq iraq) {
        this.iraq = iraq;
    }
}
