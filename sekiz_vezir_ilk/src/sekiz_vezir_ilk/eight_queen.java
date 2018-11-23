package sekiz_vezir_ilk;


import java.util.Random;

public class eight_queen {
	public static void main(String[] args) {
	       int[][] queen=new int[8][8];
		   int v=0,a,b,p,n,count=0;
		   while(v !=8)//8 vezir olana kadar
		   {
		       v=0;
			   sfirla(queen);
			   while (v!=8) {
				   Random c = new Random();
				   Random d = new Random();
				   p = c.nextInt(1000);
				   n = d.nextInt(1000);
				   a=p%8;
				   b=n%8;
				   if (queen[a][b] == 0) {
					   yerlestirme(queen, a, b);
					   v++;
				   }
				   if(dizidolumu(queen))
				   	break;
			   }


		   }
        for (int i = 7; i >= 0; i--) {
            for (int j = 0; j < 8; j++) {
                if (queen[i][j]==8)
                    System.out.print("|V");
                else
                    System.out.print("| ");
            }
            System.out.println("|\n");
        }

}

	

	private static boolean dizidolumu(int[][] queen) {
		for (int i=7;i>=0;i--) {
            for (int j = 0; j < 8; j++) {
                if (queen[i][j] == 0) {
                    return false;
                }
            }
        }
				return true;
	}

	public static void yerlestirme(int[][] queen, int a, int b) {

		int x = a;
		int y = b;
		int z = a;
		int t = b;
		int capraz1 = 0, capraz2 = 0;
		for (int k = 0; k < 8; k++)//satirlar 1
		{
			queen[x][k] = 1;
		}
		for (int k = 0; k < 8; k++) //sutunlar 1
		{
			queen[k][y] = 1;
		}
		if (x > y) {
			for (int i = x, j = y; i < 8; i++, j++) {
				capraz1 = i; capraz2 = j;
			}
			for (int i = capraz2; i >= 0; i--) {
				queen[capraz1][i] = 1; capraz1--;
			}
			while (a != 7) {
				if (b == 0)
					break;
				a++; b--;
			}
			int l = a - b;
			for (int i = 0; i <= l; i++) {
				queen[a][b] = 1;	a--;	b++;
			}
		}
		if (x <= y) {
			for (int i = x, j = y; j < 8; i++, j++) {
				capraz1 = i; capraz2 = j;
			}
			for (int i = capraz1; i >= 0; i--) {
				queen[i][capraz2] = 1;
				capraz2--;
			}
			while (a != 7) {
				if (b == 0)
					break;
				a++;
				b--;
			}
			int l = a - b;
			for (int i = 0; i <= l; i++) {
				queen[a][b] = 1;
				a--;
				b++;
			}
			}
		queen[z][t] = 8;
	}
     
	public static void sfirla(int[][] queen){
		
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				queen[i][j]=0;
			}
		}
	}
		
}
