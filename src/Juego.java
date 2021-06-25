
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
public class Juego {
    
    private String nombreJugador1;
    private String nombreJugador2;
    private String tablero[][];

    public Juego(String jugador1, String jugador2) {
        this.nombreJugador1 = jugador1;
        this.nombreJugador2 = jugador2;
        
        this.tablero = new String [3][3];
    }
    
    public void iniciarTablero(){
        
        for(int i=0; i<3; i++){
            
            for(int j=0; j<3; j++){
                
              tablero[i][j]="--";  
              
              
                
            }
        }
        
        
    }
    
    public void turno (int fila, int columna, String nombreJugador){
        
        
        
        if (this.nombreJugador1.equals(nombreJugador)){
            
            if ((tablero[fila][columna]).equals("--")){
                
                tablero[fila][columna] = "x";
                
                
            }
            
            
        }else{
            if ((tablero[fila][columna]).equals("--")){
                
                tablero[fila][columna] = "o";
                
               
            }
            
        }
        
        
    }
    
    public boolean ganador(String nombreJugador){
          
        if(this.nombreJugador1.equals(nombreJugador)){
            
            if(tablero[0][0].equals("x")&&
                    tablero[1][1].equals("x")&&tablero[2][2].equals("x") ){
                
                return true;
            }else if(tablero[0][0].equals("x")&&
                    tablero[0][1].equals("x")&&tablero[0][2].equals("x")){
                return true;
            }else if(tablero[1][0].equals("x")&&
                    tablero[1][1].equals("x")&&tablero[1][2].equals("x")){
                return true;
            }else if(tablero[2][0].equals("x")&&
                    tablero[2][1].equals("x")&&tablero[2][2].equals("x")){
                return true;
            }else if(tablero[0][0].equals("x")&&
                    tablero[1][0].equals("x")&&tablero[2][0].equals("x")){
                return true;
            }else if(tablero[0][1].equals("x")&&
                    tablero[1][1].equals("x")&&tablero[2][1].equals("x")){
                return true;
            }else if(tablero[0][2].equals("x")&&
                    tablero[1][2].equals("x")&&tablero[2][2].equals("x")){
                return true;
            }else if(tablero[0][2].equals("x")&&
                    tablero[1][1].equals("x")&&tablero[2][0].equals("x")){
                return true;
            }else{
                return false;
            }
        }else{
            if(tablero[0][0].equals("o")&&
                    tablero[1][1].equals("o")&&tablero[2][2].equals("o")){
                
                return true;
            }else if(tablero[0][0].equals("o")&&
                    tablero[0][1].equals("o")&&tablero[0][2].equals("o")){
                return true;
            }else if(tablero[1][0].equals("o")&&
                    tablero[1][1].equals("o")&&tablero[1][2].equals("o")){
                return true;
            }else if(tablero[2][0].equals("o")&&
                    tablero[2][1].equals("o")&&tablero[2][2].equals("o")){
                return true;
            }else if(tablero[0][0].equals("o")&&
                    tablero[1][0].equals("o")&&tablero[2][0].equals("o")){
                return true;
            }else if(tablero[0][1].equals("o")&&
                    tablero[1][1].equals("o")&&tablero[2][1].equals("o")){
                return true;
            }else if(tablero[0][2].equals("o")&&
                    tablero[1][2].equals("o")&&tablero[2][2].equals("o")){
                return true;
            }else if(tablero[0][2].equals("o")&&
                    tablero[1][1].equals("o")&&tablero[2][0].equals("o")){
                return true;
            }else{
                return false;
            }
        }
        
        
    }
    
    
    
    
    public String [][] getTablero(){
        
        return tablero;
    }
    
}
