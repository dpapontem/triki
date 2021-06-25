
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DERLY
 */
public class Partida {
    
    private Juego juego;
    private int turno;
    private boolean ganador;
    private String nombreGanador;
    
    
    
    public void partida(){
        
        int numeroJugadas= 9;
        int jugadas=0;
        int [] posiciones = new int[2];
        ganador=true;
        
        
        String jugador1 = JOptionPane.showInputDialog(
                "Ingrese el nombre del jugador 1: ");
        turno=1;
        String jugador2 = JOptionPane.showInputDialog(
                "Ingrese el nombre del Jugador 2: ");
        
        juego=new Juego(jugador1,jugador2);
        juego.iniciarTablero();
        
        while (numeroJugadas != 0 && ganador){
            
            
            
            if(turno==1){
                
                posiciones=validacion();
                while(posiciones == null || posiciones[0]>3 ||
                        posiciones[1]>3 ){
                    JOptionPane.showMessageDialog(null,
                    "los datos no son enteros o son amyores "
                            + "a 3 ingreselos nuevmante",
                                "Advertencia",JOptionPane.WARNING_MESSAGE);
                    posiciones=validacion();
                }
                juego.turno(posiciones[0]-1,posiciones[1]-1,jugador1);
                
                numeroJugadas= numeroJugadas-1;
                jugadas++;
                boolean experimento = juego.ganador(jugador1);
                if(jugadas>4){
                    experimento = juego.ganador(jugador1);
                    System.out.println(experimento);
                    if(experimento){
                        ganador=false;
                        nombreGanador=jugador1;
                        JOptionPane.showMessageDialog(null, "el ganardor es: "+
                                nombreGanador);
                    }
                }
                mostrarPartida();
                turno=2;
            }else{
                
                posiciones=validacion();
                
                while(posiciones == null || posiciones[0]>3 ||
                        posiciones[1]>3 ){
                    JOptionPane.showMessageDialog(null,
                    "los datos no son enteros o son amyores "
                            + "a 3 ingreselos nuevmante",
                                "Advertencia",JOptionPane.WARNING_MESSAGE);
                    posiciones=validacion();
                }
                juego.turno(posiciones[0]-1,posiciones[1]-1,jugador2);
                
                numeroJugadas= numeroJugadas-1;
                jugadas++;
                if(jugadas>4){
                    
                    if(juego.ganador(jugador2)){
                        ganador=false;
                        nombreGanador=jugador2;
                        JOptionPane.showMessageDialog(null, "el ganardor es: "+
                                nombreGanador);
                    }
                }
                
                mostrarPartida();
                turno=1;
            }
            
            if(jugadas==8 && ganador){
                
                JOptionPane.showMessageDialog(null, "Tenemos un empate");
                ganador=false;               
                
            }
            
        }
        
    }
    
    public int[] validacion(){
        
        int [] pocionFinal = new int[2];
        String posicion = JOptionPane.showInputDialog(
                "ingrese la posicion de la jugada ej: (1,1): ");
        
        
        String [] pocision = posicion.split(",");
        
        try{
            pocionFinal[0]=Integer.parseInt(pocision[0]);
            pocionFinal[1]=Integer.parseInt(pocision[1]);
            
            
            
            return pocionFinal;
        }
        catch(Exception noEntero){
            
            return null;
        }
         
         
        
        
    }
    
    public void mostrarPartida(){
        
        
        String [][]tablero = new String [3][3];
        tablero=juego.getTablero();
        
        String bosquejo="|"+tablero[0][0]+" "+ tablero[0][1]+" "+
                tablero[0][2]+ "|\n"+
                "|"+tablero[1][0]+" "+ tablero[1][1]+" "+
                tablero[1][2]+ "|\n"+
                        "|"+tablero[2][0]+" "+ tablero[2][1]+" "+
                tablero[2][2]+ "|\n";
        
        JOptionPane.showMessageDialog(null, bosquejo);
        
        
    }
}
