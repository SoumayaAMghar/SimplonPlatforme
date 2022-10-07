package service;

import java.util.ArrayList;

public class PromotionService {

    public PromotionService(){

    }
    public void display(Promotion promotion){
        System.out.println("formateur"+promotion.getFormateurName());
        System.out.println("name"+promotion.getPromoName());
        for (Apprenant student : promotion.getStudents()) {
            System.out.println(student);
        }
    }
}
