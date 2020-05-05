
public class CodificaMensagem {

	private static final char[] ALFABETO = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
			'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String msg = "a ligeira raposa marrom saltou sobre o cachorro cansado";
		int numeroCasas = 3;
		msg = codifica(msg, numeroCasas);
		decodifica(msg, numeroCasas);
	}

	public static String codifica(String msg, Integer numeroCasas) {
		System.out.println("INICIANDO CODIFICAÇÃO");
		
		char caracterCrip = 0;
		String texto = "";
		msg = msg.toLowerCase();
		
		for(int i =0; i < msg.length(); i++) {
			caracterCrip= encriptaCharacter(numeroCasas, (char)msg.charAt(i));
			texto += caracterCrip;
		} 
		
		System.out.printf("DeCodificado: %s\n", texto);
		System.out.println("FINALIZANDO CODIFICAÇÃO");
		return texto;
	}
	
	public static String decodifica(String msg, Integer numeroCasas) {
		System.out.println("INICIANDO DECODIFICAÇÃO");
		
		char caracterCrip = 0;
		String texto = "";
		msg = msg.toLowerCase();
		
		for(int i =0; i < msg.length(); i++) {
			caracterCrip= decriptaCharacter(numeroCasas, (char)msg.charAt(i));
			texto += caracterCrip;
		} 
		
		System.out.printf("DeCodificado: %s\n", texto);
		System.out.println("FINALIZANDO DECODIFICAÇÃO");
		return texto;
	}

	private static char encriptaCharacter(int indice, char charAt) {
		if(Character.isAlphabetic(charAt)) {
			int pos = 0;
			for(int i=0; i < ALFABETO.length; i++) {
				if( ALFABETO[i] == charAt) {
					pos = i;	
					break;
				}
			}
			while(indice > 0) {
				if(pos == ALFABETO.length)
					pos = 0;
				pos++;
				indice--;
			}
			return ALFABETO[pos];
		}
		return charAt;
	}	
	@SuppressWarnings("unused")
	private static char decriptaCharacter(int indice, char charAt) {
		if(Character.isAlphabetic(charAt)) {
			int pos = 0;
			for(int i=0; i < ALFABETO.length; i++) {
				if( ALFABETO[i] == charAt) {
					pos = i;	
					break;
				}
			}
			while(indice > 0) {
				if(pos == 0)
					pos = ALFABETO.length;
				pos--;
				indice--;
			}
			return ALFABETO[pos];
		}
		return charAt;
	}
}

