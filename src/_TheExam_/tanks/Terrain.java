package _TheExam_.tanks;

import java.util.ArrayList;
import java.util.List;

public class Terrain {

    private String type;
    private List<Tank> tanks;
    private int area;

    public Terrain(String type, int area) {
        this.type = type;
        this.area = area;
        this.tanks = new ArrayList<>();
    }


    public String addTank(Tank tank) {

        for(Tank curTank : tanks){
            if(curTank.getBrand().equals(tank.getBrand()) && curTank.getModel().equals(tank.getModel())){
                return "Tank with this brand and model already exists!";
            }
        }
        if(this.type.equals("Swamp") && tank.getWeight() > 14000){
            return String.format("This %s is too heavy for this terrain!", tank.getBrand());
        } else {
           tanks.add(tank);
            return String.format("Tank %s %s added.", tank.getBrand(), tank.getModel());
        }
    }

    public boolean removeTank(String brand, String model){
        for (Tank curTank : tanks) {
            if(curTank.getBrand().equals(brand) && curTank.getModel().equals(model)){
                tanks.remove(curTank);
                return true;
            }
        }
        return false;
    }


    public String getTanksByBarrelCaliberMoreThan(int barrelCaliber) {
        List<Tank> result = new ArrayList<>();
        for(Tank curTank :tanks) {
            if(curTank.getBarrelCaliber() >= barrelCaliber){
                result.add(curTank);
            }
        }
        if(result.isEmpty()){
            return "There are no _TheExam_.tanks with the specified caliber.";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Tanks with caliber more than ").append(barrelCaliber).append("mm: ");
        for (Tank tank : result){
            sb.append(tank.getBrand()).append(", ");
        }
        sb.setLength(sb.length() -2);

        return sb.toString();
    }

    public Tank getTankByBrandAndModel(String brand, String model){
        for(Tank curTank :tanks) {
            if(curTank.getBrand().equals(brand) && curTank.getModel().equals(model)){
                return curTank;
            }
        }
        return null;
    }

    public String getTheMostArmoredTank() {
        int max = Integer.MIN_VALUE;
        String brand = "";
        String model = "";
        for (Tank curTank : tanks) {
            if(curTank.getArmor() > max){
                max = curTank.getArmor();
                brand = curTank.getBrand();
                model = curTank.getModel();
            }
        }
        return String.format("%s %s is the most armored tank with %dmm. armor thickness.", brand, model, max);
    }

    public int getCount() {
        return tanks.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tanks located in the ").append(type.toLowerCase()).append(":\n");
        if(tanks.isEmpty()){
            return String.format("There are no _TheExam_.tanks in the %s.", type.toLowerCase());
        }
        tanks.forEach(tank -> sb.append("-- ").append(tank.getBrand()).append(" ").append(tank.getModel()).append("\n"));

        sb.setLength(sb.length() - 1);
        return sb.toString();
    }





}
