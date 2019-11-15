package com.game.housie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

@Service
public class TicketGenService {

    // call model ticket
    @Autowired
    TicketGenService ticketGenService;

    private int[][] generateTicket (){
        int res[][]=new int[3][9];
        Set<Integer> s=new TreeSet<Integer>();
        int counter=3;
        int min=1;
        int max=9;
        while(counter<=27){

            int val=ticketGenService.generateRandom(min,max);
            s.add(val);
            if(s.size()==counter ){
                counter+=3;
                min=max+1;
                max=max+10;
            }
        }
        int counti=0;
        int countj=0;

        for(int i:s){

            res[counti][countj]=i;
            counti++;
            if(counti==3){
                counti=0;
                countj++;
            }
        }

        return ticketGenService.finalTicket(res);
    }
    private int[][] finalTicket(int [][]res){
        int min=1;
        int max=9;

        int column=1;
        int row=1;
        Set<Integer> s=new HashSet<Integer>();
        int [][]tt=new int[3][4];
        boolean bool=false;
        while(row <=3 ){

            int val=ticketGenService.generateRandom(min,max);

            if(row==3){
                bool=false;
                if(res[0][val-1]==0 && res[1][val-1]==0){
                    bool=true;
                }
            }
            if(!bool) {
                s.add(val);
            }
            if(s.size()==4 && row<=3){
                column=0;
                for(int sdata:s){
                    tt[row-1][column++]=sdata;
                    res[row-1][sdata-1]=0;
                }
                row++;
                s.clear();
            }
        }
        return res;
    }
    private int generateRandom(int min,int max){
        Random r=new Random();
        int val=-1;
        while(val<min) {
            val = r.nextInt(max);
        }
        return val;
    }
}
