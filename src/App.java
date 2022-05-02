import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        
        String cpf;
        int baseMultiplicadora = 10;
        int recebeSomaCpf = 0;
        int PenultimoDigito;
        int UltimoDigito;
        int totalDigitosCpf = 11;
        int NumeroCpf;
        char recebeDigito; 
        boolean PenultimoDigitoValido = false;
        boolean UltimoDigitoValido = false;

        System.out.print("Digite seu CPF: ");        
        cpf = input.nextLine();


        //*********************************CALCULO DO PRIMEIRO DIGITO*****************************

          for (int posicaoDigito = 0; posicaoDigito < 9; posicaoDigito++) {
            recebeDigito= cpf.charAt(posicaoDigito);
                     
            NumeroCpf = Integer.parseInt(String.valueOf(recebeDigito));

          
            recebeSomaCpf += NumeroCpf * baseMultiplicadora; 
            baseMultiplicadora--;

          }  
        
        

        PenultimoDigito = totalDigitosCpf - (recebeSomaCpf % totalDigitosCpf);
        

        recebeDigito= cpf.charAt(9);                     
        NumeroCpf = Integer.parseInt(String.valueOf(recebeDigito));

        // valida o penultimo digito do cpf
        if(PenultimoDigito == NumeroCpf){

            PenultimoDigitoValido = true;           
        }else if(PenultimoDigito >= 10){

            PenultimoDigito = 0;

            if(PenultimoDigito == NumeroCpf){

                PenultimoDigitoValido = true;  
            }else{

                PenultimoDigitoValido = false;
            }
        }

     

        //***********************************CALCULO ULTIMO DIGITO DO CPF********************************
        if(PenultimoDigitoValido){

            //resetar valores importantes            
            recebeSomaCpf = 0;
            NumeroCpf = 0;
            baseMultiplicadora = 11;

            for (int posicaoDigito = 0; posicaoDigito < 10; posicaoDigito++) {
                //resetar valores importantes
               

                recebeDigito= cpf.charAt(posicaoDigito);                       
                NumeroCpf = Integer.parseInt(String.valueOf(recebeDigito));
    
              //System.out.println(NumeroCpf);
              
                recebeSomaCpf += NumeroCpf * baseMultiplicadora;
                
                baseMultiplicadora--;
                
              }  

        }else{
            System.out.println("Primeiro Digito CPF invalido");
        }

        UltimoDigito = 11 - (recebeSomaCpf % 11);        

        recebeDigito= cpf.charAt(10);                     
        NumeroCpf = Integer.parseInt(String.valueOf(recebeDigito));

        //VAlida o ultimo digito do cpf
        if(UltimoDigito == NumeroCpf){

            UltimoDigitoValido = true;           
        }else if(UltimoDigito >= 10){

            UltimoDigito = 0;

            if(UltimoDigito == NumeroCpf){

                UltimoDigitoValido = true;  
            }else{

                UltimoDigitoValido = false;
            }
        }

        // valida o ultimo digito do cpf       

        if(UltimoDigitoValido && PenultimoDigitoValido){
                System.out.println("CPF VALIDADO COM SUCESSO!");
        }else{
            System.out.println("CPF INVALIDO!");
        }      



        input.close();

    }
}
