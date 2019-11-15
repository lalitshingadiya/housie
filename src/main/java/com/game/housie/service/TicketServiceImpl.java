package com.game.housie.service;

import com.game.housie.dao.TicketDAOService;
import com.game.housie.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TicketServiceImpl implements TicketService {


    @Autowired
    TicketDAOService ticketDAOServiceImpl;

    public boolean genTickets(int empcode,int createdby,int category,int nooftickets){
        int i=0;
        boolean bResult=false;
        while(i<nooftickets) {
            int[][] ticket = generateTicket();

            Ticket t=new Ticket();
            t.setCategory(category);
            t.setEmpCode(empcode);
            t.setOrgTicket(Arrays.deepToString(ticket));
            t.setCurrentTicket(Arrays.deepToString(ticket));

            Ticket t1=ticketDAOServiceImpl.save(t);

            if(t1.getTicketId()>0){
                bResult=true;
            }


            i++;
        }
        return bResult;
    }
    public String renderingTickets(int empcode){
        return "";
    }
    public boolean updatingResult(int ticketNo){
        boolean bResult=false;

        java.util.Optional <Ticket> t1 =ticketDAOServiceImpl.findById(ticketNo);


        Ticket t2=ticketDAOServiceImpl.findById(ticketNo).get();
        t2.setResult("1234");
        Ticket t3=new Ticket();
        t3=t2;
        t3.setResult("2345");

        ticketDAOServiceImpl.save(t2);


        return bResult;

    }

    public int generateRandomTokens(){
        return 0;
    }


    private int[][] generateTicket (){
        int res[][]=new int[3][9];
        Set<Integer> s=new TreeSet<Integer>();
        int counter=3;
        int min=1;
        int max=9;
        while(counter<=27){

            int val=generateRandom(min,max);
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

        return finalTicket(res);
    }
    private int[][] finalTicket(int [][]res){
        int min=1;
        int max=9;

        int column=1;
        int row=1;
        Set<Integer> s=new HashSet<>();
        int [][]tt=new int[3][4];
        boolean bool=false;
        while(row <=3 ){

            int val=generateRandom(min,max);

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
