import java.util.*;

class Main {
    interface DeliveryStore{
        public void setOrderList(String[] orderList);
        public int getTotalPrice();
    }

    class Food{
        public String name;
        public int price;
        public Food(String name, int price){
            this.name = name;
            this.price = price;
        }
    }

    class PizzaStore implements DeliveryStore{
        private ArrayList<Food> menuList;
        private ArrayList<String> orderList;

        public PizzaStore(){ // 생성자
            menuList = new ArrayList<Food>();
            String[] menuNames = {"Cheese", "Potato", "Shrimp", "Pineapple", "Meatball"};
            int[] menuPrices = {11100, 12600, 13300, 21000, 19500};
            for(int i = 0; i < 5; i++)
                menuList.add(new Food(menuNames[i], menuPrices[i]));

            orderList = new ArrayList<String>();
        }

        public void setOrderList(String[] orderList){
            for(int i = 0; i < orderList.length; i++)
                this.orderList.add(orderList[i]);
        }

        public int getTotalPrice(){
            int totalPrice = 0;
            Iterator<String> iter = orderList.iterator(); //Iterator 반복자
            while (iter.hasNext()) {
                String order = iter.next();
                System.out.println(order); //확인용
                for(int i = 0; i < menuList.size(); i++)
                    if(order.equals(menuList.get(i).name))
                        totalPrice += menuList.get(i).price; //get()사용
            }
            return totalPrice;
        }
    }

    public int solution(String[] orderList) {
        DeliveryStore deliveryStore = new PizzaStore();

        deliveryStore.setOrderList(orderList); //주문 메뉴를 받아 order_list에 저장

        int totalPrice = deliveryStore.getTotalPrice();

        return totalPrice;
    }

    public static void main(String[] args) {
        Main sol = new Main();  //Main 클래스의 인스턴스 생성
        String[] orderList = {"Cheese", "Pineapple", "Meatball"}; //string 타입의 배열 선언 및 생성
        int ret = sol.solution(orderList); //solution 함수 호출

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}