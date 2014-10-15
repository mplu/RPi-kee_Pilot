package misc;

public class CRC
{
	public static short CRC16(byte[] ptrMessage,short NbMessage)
	{
		byte Calcul1, Calcul2 ;
		byte Decalage, Decal2 ;
		short temp1,temp2;
		short Calcul = (short) 0xFFFF;
	    byte j,i;

	    for( j = 0 ; j < NbMessage; j++)
	    {
	        Calcul ^= (ptrMessage[j]  << 8);
	        for (i = 0 ; i < 8; i++)
	        {
	            Decalage = 0;
	            Decal2 = 0 ;
	            if((Calcul & 0x0001) == 1)
	            {
	                Decalage = 1 ;
	            }
	            if((Calcul & 0x0100) != 0)
	            {
	                Decal2 = 1 ;
	            }
	            Calcul1 = (byte) Calcul;
	            temp1 = 0;
	            temp1 |= Calcul1;
	            temp1 &= 0xFF;
	            Calcul1 = (byte) (temp1 >>1) ;
	            Calcul2 = (byte)(Calcul >> 8);
	            temp2 = 0;
	            temp2 |= Calcul2;
	            temp2 &= 0xFF;
	            Calcul2 = (byte)(temp2 >> 1) ;
	            if(Decalage == 1 )
	            {
	                Calcul2 |= 0x80 ;
	            }
	            Calcul = (short) ((Calcul2 << 8) | Calcul1) ;
	            if(Decal2 == 1)
	            {
	                Calcul ^= 0x01A0 ;
	            }
	        }
	    }
	    return(Calcul);
	}

	
}
