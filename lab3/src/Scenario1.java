public class Scenario1 {
    public void script(Malysh malysh, MoneyBox pig, Carlson carlson, Knife knife){
        malysh.takeKnife(knife);
        while (pig.getWeight() > 0){
            switch (malysh.takeCoin(pig)){
                case 5:
                    carlson.setStatus(Status.VERY_ENJOY);
                    System.out.println(carlson.toString());
                    System.out.println(malysh.toString());
                    break;
                case 10:
                    carlson.setStatus(Status.ENJOY);
                    System.out.println(carlson.toString());
                    System.out.println(malysh.toString());
                    break;
                case 25:
                    carlson.setStatus(Status.ENJOY);
                    System.out.println(carlson.toString());
                    System.out.println(malysh.toString());
                    break;
                default:
                    System.out.println("error");
                    break;
            }
        }
        System.out.println("The box is empty");
        malysh.setStatus(Status.MOTHER);
        System.out.println(carlson.toString());
        System.out.println(malysh.toString());

    }
}
