package com.perfios.cricket;

import java.util.*;
import java.util.stream.Collectors;

public class DisplayUpdate {
    static List<Cricketer> myTeam ;
    Map<String,Cricketer> myMap = new TreeMap<>();

    //Update player
    public void updatePlayerByName() throws PlayerNotFoundException {
        Scanner sc = new Scanner(System.in);


        for(Cricketer crick:myTeam){
            myMap.put(crick.getName(), crick);
        }
        System.out.println("Enter Player name to be updated.");
        String playerName = sc.nextLine();


        Cricketer player = myMap.get(playerName);
        if(player == null){
            PlayerNotFoundException playerNotFoundException = new PlayerNotFoundException("Player with same name not found.");
            throw (playerNotFoundException);
        }

        myMap.remove(playerName);


        sc.nextLine();
        System.out.println("Enter updated player name.");
        player.setName(sc.nextLine());
        System.out.println("Enter updated number of matches played.");
        player.setMatchesPlayed(sc.nextInt());
        System.out.println("Enter updated number of runs scored.");
        player.setRuns(sc.nextInt());
        System.out.println("Enter updated number of wickets taken.");
        player.setWicket(sc.nextInt());
        System.out.println("Enter updated number of outs on zero.");
        player.setDuck(sc.nextInt());
        System.out.println("Enter updated type of player-  1: Bowler , 2: Batsman , 3:Wicket-Keeper , 4: All-Rounder");
        switch (sc.nextInt()){
            case 1:
                player.setPlayerType(2);
                break;
            case 2:
                player.setPlayerType(1);
                break;
            case 3:
                player.setPlayerType(3);
                break;
            case 4:
                player.setPlayerType(4);
                break;
            default:
                System.out.println("Player is set as batsman.");
                player.setPlayerType(1);
                break;
        }

        myMap.put(player.getName(),player);
    }
    //display single player
    public void displaySinglePlayer(Cricketer player){
        System.out.println(  player.getName() + "\t" + player.getMatchesPlayed() + "\t" + player.getRuns() + "\t" + player.getWicket() +"\t" + player.getDuck() + "\t" + player.getPlayerType());
    }
    //displaying players
    public void displayAllPlayers(){
        System.out.println("All Players: ");
        System.out.println("Name\tMatches Played\tRuns Scored\tWickets Taken\tDucks\tPlayer type");
        myMap.values().stream().collect(Collectors.toList()).stream().sorted(new PlayerNameComparator()).forEach(player -> displaySinglePlayer(player));
    }

    public static void main(String[] args) {
        int bowlerCount=0;
        int allRounderCount =0;
        boolean valid=false;
        Scanner sc = new Scanner(System.in);
        myTeam=  new ArrayList<>();
        while(!valid){
            myTeam.removeAll(myTeam);
            for(int i =0;i<20;i++){
                Cricketer player = new Cricketer();
                System.out.println("Please Enter the players name");

                player.setName(sc.nextLine());

                System.out.println("Please Enter the players type  1 for Batsman ,2 for bowler ,3 for wickekeeper,4 for allrounder");

                player.setPlayerType(sc.nextInt());
                if(player.getPlayerType()==2){
                    bowlerCount++;
                }else{
                    allRounderCount++;
                }
                System.out.println("Please Enter the number of wickets taken");
                player.setWicket(sc.nextInt());
                System.out.println("Please Enter the number of matches played");
                player.setMatchesPlayed(sc.nextInt());
                System.out.println("Please Enter the runs scored");
                player.setRuns(sc.nextInt());

                System.out.println("Please Enter the number of times duck scored");
                player.setDuck(sc.nextInt());
                sc.nextLine();

                player.average= player.getRuns()/ player.getMatchesPlayed();
                if(bowlerCount>3 && allRounderCount>=1){
                    valid=true;
                }
                myTeam.add(player);

            }
        }




        System.out.println("id  "+ "  Matches Played  "+"  Runs  "+"  Wickets Taken  "+"  Duck  "+"  Player Type");

        for(int i =0;i<20;i++){
            System.out.println(i+"\t\t\t"+myTeam.get(i).getMatchesPlayed()+"\t\t\t"+myTeam.get(i).getRuns()+"\t\t\t"+myTeam.get(i).getWicket()+"\t\t\t"+myTeam.get(i).getDuck()+"\t\t\t"+myTeam.get(i).getPlayerType());
        }

        myTeam.stream().sorted();
        int bowlerInEleven=0;
        int wkInEleven=0;
        List<Cricketer> playingEleven = new ArrayList<>();
        //Adding top 7 player according to average and cheking how many bowlers are there
        for(int i =0;i<7;i++){
            playingEleven.add(myTeam.get(i));

            if(playingEleven.get(i).getPlayerType()==2){

                bowlerInEleven++;
            } else if (playingEleven.get(i).getPlayerType()==4) {

                wkInEleven++;
            }

        }

        //Making sure there are at least 3 bowler and one wicketkeeper
        for(int i=8;i<20;i++){
            while(bowlerInEleven<=3){
                if(myTeam.get(i).getPlayerType()==2){
                    Cricketer player=myTeam.get(i);
                    playingEleven.add(player);
                    bowlerInEleven++;
                }
            }while(wkInEleven<1){
                if(myTeam.get(i).getPlayerType()==4){
                    Cricketer player=myTeam.get(i);
                    playingEleven.add(player);
                    wkInEleven++;
                }
            }


        }
    }
}


