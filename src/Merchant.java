public class Merchant implements Seller {
    //Метод для продажи
    @Override
    public String sell(Goods goods) {
        String result = "";
        if (goods == Goods.POTION) {
            result = "potion";
        }
        return result;
    }
    public enum Goods {
        POTION
    }
}