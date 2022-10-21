import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Integer> playerPos = new ArrayList<>();
    static ArrayList<Integer> player2Pos = new ArrayList<>();
    static ArrayList<Integer> cpuPos = new ArrayList<>();
    static ArrayList<Integer> listPosition = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {

        //TicTacToe Java Game:
        String[][] broadGame = {{" "," ", "|"," "," "," ", "|"," ", " "},
        {"--", "+","---", "+", "--"},
        {" "," ", "|"," "," "," ", "|"," ", " "},
        {"--", "+","---", "+", "--"},
        {" "," ", "|"," "," "," ", "|"," ", " "}};


        while (true){
            removePosition();

            clearBroadGame(broadGame);

            printGameBroad(broadGame);

            selectMode(broadGame);

        }


    }


    public static void removePosition(){
        //delete all pos pev round:
        player2Pos.removeAll(player2Pos);
        playerPos.removeAll(playerPos);
        cpuPos.removeAll(cpuPos);
    }


    public static void selectMode(String[][] broadGame) throws InterruptedException {
        System.out.println();
        System.out.println("Select mode :");
        System.out.println("Press 1 :Player vs Player!");
        System.out.println("Press 2 :Player vs CPU!");
        int mode = scanner.nextInt();
        switch (mode){
            case 1:
                PlayervsPlayer(broadGame);
                break;
            case 2:
                PlayervsCPU(broadGame);
                break;
            default:
                System.out.println("Only 2 mode");
                break;
        }
    }


    public static void PlayervsPlayer(String[][] broadGame){
        while (true){
            //Player turn:
            System.out.println("Input player1 position(0-9):");
            int positionPlayer = scanner.nextInt();
            while(playerPos.contains(positionPlayer) || player2Pos.contains(positionPlayer)){
                System.out.println("Position taken, type again:");
                positionPlayer = scanner.nextInt();
            }
            inputPosition(broadGame,"player1",positionPlayer);
            String result = checkWinner();
            if(result.length() > 0){
                System.out.println(result);
                break;
            }


            //Player 2 turn:
            System.out.println("Input player2 position(0-9):");
            int positionPlayer2 = scanner.nextInt();
            while(player2Pos.contains(positionPlayer2) || playerPos.contains(positionPlayer2)){
                System.out.println("Position taken, type again:");
                positionPlayer2 = scanner.nextInt();
            }
            inputPosition(broadGame,"player2",positionPlayer2);
            result = checkWinner();
            if(result.length() > 0){
                System.out.println(result);
                break;
            }
        }
    }



    public static void PlayervsCPU(String[][] broadGame) throws InterruptedException {
        while (true){
            //Player turn:
            System.out.println("Input player1 position(0-9):");
            int positionPlayer = scanner.nextInt();
            while(playerPos.contains(positionPlayer) || cpuPos.contains(positionPlayer)){
                System.out.println("Position taken, type again:");
                positionPlayer = scanner.nextInt();
            }
            inputPosition(broadGame,"player1",positionPlayer);
            String result = checkWinner();
            if(result.length() > 0){
                System.out.println(result);
                break;
            }


            //CPU turn:
            System.out.println("CPU is thinking.");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("CPU is thinking..");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("CPU is thinking...");
            TimeUnit.SECONDS.sleep(1);
            Random random = new Random();
            int timeCpuThink = random.nextInt(2)+1;
            TimeUnit.SECONDS.sleep(timeCpuThink);
            int positionCPU = random.nextInt(9) + 1;
            while(cpuPos.contains(positionCPU) || playerPos.contains(positionCPU)){
                positionCPU = random.nextInt(9) + 1;
            }
            inputPosition(broadGame,"cpu",positionCPU);
            result = checkWinner();
            if(result.length() > 0){
                System.out.println(result);
                break;
            }
        }
    }


    public static void printGameBroad(String[][] broadGame){
        System.out.println("TIC TAC TOE GAME !");
        for(String[] row : broadGame){
            for(String c : row){
                System.out.print(c);
            }
            System.out.println();
        }
    }


    public static void inputPosition(String[][] broadGame,String player,int position){
        String sign = "";

        if(player == "player1"){
            sign = "X";
            playerPos.add(position);
        }else if(player == "player2"){
            sign = "0";
            player2Pos.add(position);
        }else{
            sign = "0";
            cpuPos.add(position);
        }

        StringBuffer buffer = new StringBuffer();
        buffer.append(sign);

        //show what position taken:
        listPosition.add(position);
        System.out.println(listPosition);

        for(int i = 0;i<listPosition.size();i++){
            int pos = listPosition.get(i);
            if(pos==1){
                broadGame[0][0] = broadGame[0][0].replace("*","");
            }else if(pos==2){
                broadGame[0][4] = broadGame[0][4].replace("*","");
            }
            else if(pos==3){
                broadGame[0][8] = broadGame[0][8].replace("*","");
            }
            else if(pos==4){
                broadGame[2][0] = broadGame[2][0].replace("*","");
            }
            else if(pos==5){
                broadGame[2][4] = broadGame[2][4].replace("*","");
            }
            else if(pos==6){
                broadGame[2][8] = broadGame[2][8].replace("*","");
            }
            else if(pos==7){
                broadGame[4][0] = broadGame[4][0].replace("*","");
            }
            else if(pos==8){
                broadGame[4][4] = broadGame[4][4].replace("*","");
            }
            else if(pos==9){
                broadGame[4][8] = broadGame[4][8].replace("*","");
            }
        }


        switch (position){
            case 1:
                broadGame[0][0] = buffer.toString()+"*";
                break;
            case 2:
                broadGame[0][4] = buffer.toString()+"*";
                break;
            case 3:
                broadGame[0][8] = buffer.toString()+"*";
                break;
            case 4:
                broadGame[2][0] = buffer.toString()+"*";
                break;
            case 5:
                broadGame[2][4] = buffer.toString()+"*";
                break;
            case 6:
                broadGame[2][8] = buffer.toString()+"*";
                break;
            case 7:
                broadGame[4][0] = buffer.toString()+"*";
                break;
            case 8:
                broadGame[4][4] = buffer.toString()+"*";
                break;
            case 9:
                broadGame[4][8] = buffer.toString()+"*";
                break;
            default:
                if(position<1 || position >9){
                    System.out.println("Wrong input");
                }
            }



        printGameBroad(broadGame);
    }


    public static String checkWinner(){
        //horizon:
        List<Integer> topRow = Arrays.asList(1,2,3);
        List<Integer> midRow = Arrays.asList(4,5,6);
        List<Integer> botRow = Arrays.asList(7,8,9);

        //vertical:
        List<Integer> leftCol = Arrays.asList(1,4,7);
        List<Integer> midCol = Arrays.asList(2,5,8);
        List<Integer> botCol = Arrays.asList(3,6,9);

        //cross:
        List<Integer> cross1 = Arrays.asList(1,5,9);
        List<Integer> cross2 = Arrays.asList(3,5,7);

        List<List> listPosWin = new ArrayList<>();
        listPosWin.add(leftCol);
        listPosWin.add(midCol);
        listPosWin.add(botCol);
        listPosWin.add(topRow);
        listPosWin.add(midRow);
        listPosWin.add(botRow);
        listPosWin.add(cross1);
        listPosWin.add(cross2);

        for(List l : listPosWin){
            if(playerPos.containsAll(l) || playerPos.size() + cpuPos.size() == 9  && playerPos.containsAll(l)){
                return "Player1 won";
            }else if(cpuPos.containsAll(l) || cpuPos.size() + playerPos.size() == 9  && cpuPos.containsAll(l)){
                return "CPU won";
            }else if (player2Pos.containsAll(l) || player2Pos.size() + playerPos.size() == 9  && player2Pos.containsAll(l)){
                return "Player2 won";
            }
//            215346978
        }
        if(playerPos.size() + cpuPos.size() == 9 || playerPos.size() + player2Pos.size() == 9){
            return "Full broad";
        }
        return "";


    }

    public static void clearBroadGame(String[][] broadGame){
        broadGame[0][0] = " ";
        broadGame[0][4] = " ";
        broadGame[0][8] = " ";
        broadGame[2][0] = " ";
        broadGame[2][4] = " ";
        broadGame[2][8] = " ";
        broadGame[4][0] = " ";
        broadGame[4][4] = " ";
        broadGame[4][8] = " ";
    }
}
