package factory.simple;

/**
 * 折扣消费
 */
class CashRebate extends CashSuper{
    private double moneyRebate;

    public CashRebate(double moneyRebate) {
        this.moneyRebate = moneyRebate;
    }
    @Override
    public double acceptCash(double money) {
        return money*moneyRebate;
    }
}
