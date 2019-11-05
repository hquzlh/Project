package factory.simple;

/**
 * 正常消费
 */
class CashNormal extends CashSuper{
    @Override
    public double acceptCash(double money) {
        return money;
    }
}
