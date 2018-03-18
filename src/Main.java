import sokoban.Cell;
import sokoban.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) {
            boolean escape = false;
            while(!escape)
            try {
                    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                    System.out.println("Lehetőségek:");
                    System.out.println("0: Kilépés");
                    System.out.println("1: Pályagenerálás");
                    System.out.println("2: Játékos üres mezőre mozog");
                    System.out.println("3: Játékos falnak ütközik");
                    System.out.println("4: Játékos lyukba esik");
                    System.out.println("5: Doboz eltolás üres mezőre");
                    System.out.println("6: Doboz falnak tolá1sa");
                    System.out.println("7: Doboz lyukba tolása");
                    System.out.println("8: Doboz kapcsolóra tolása");
                    System.out.println("9: Dobozzal másik doboz tolása");
                    System.out.println("10: Másik játékos eltolása");
                    System.out.println("11: Játékos falnak tolása");
                    System.out.println("12: Játékos lyukba lökése");
                    System.out.println("13: Játékos nem továbbtolható mezőre tolása");
                    System.out.println("14: Játékos továbbtolható mezőre tolása");
                    System.out.println("15: Kinyíló lyukon doboz áll");
                    System.out.println("16: Kinyíló lyukon másik játékos áll");
                    System.out.println("17: Kinyíló lyukon a toló játékos áll");
                    System.out.println("18: Játékos célra lép");
                    System.out.println("19: Dobozt célra tolják");
                    String s = br.readLine();
                    switch (s){
                            case "0":
                                    escape = true;
                                    break;
                            case "1":
                                    Test1.run();
                                    break;
                            case "2":
                                    Test2.run();
                                    break;
                            case "3":
                                    Test3.run();
                                    break;
                            case "4":
                                    Test4.run();
                                    break;
                            case "5":
                                    Test5.run();
                                    break;
                            case "6":
                                    Test6.run();
                                    break;
                            case "7":
                                    Test7.run();
                                    break;
                            case "8":
                                    Test8.run();
                                    break;
                            case "9":
                                    Test9.run();
                                    break;
                            case "10":
                                    Test10.run();
                                    break;
                            case "11":
                                    Test11.run();
                                    break;
                            case "12":
                                    Test12.run();
                                    break;
                            case "13":
                                    Test13.run();
                                    break;
                            case "14":
                                    Test14.run();
                                    break;
                            case "15":
                                    Test15.run();
                                    break;
                            case "16":
                                    Test16.run();
                                    break;
                            case "17":
                                    Test17.run();
                                    break;
                            case "18":
                                    Test18.run();
                                    break;
                            case "19":
                                    Test19.run();
                                    break;
                            default:
                                    System.out.println("Rossz input!");
                    }
            } catch (Exception e){
                    System.out.println(e);
            }
    }
}
