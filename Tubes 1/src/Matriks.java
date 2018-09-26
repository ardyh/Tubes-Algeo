import java.util.Scanner;

public class Matriks {
	int nbaris;
	int nkolom;
	float[][] tab = new float[55][55];
	
	public Matriks() { //Konstruktor
		int i, j;
		
		for(i = 1; i <= 50; i++) {
			for(j = 1; j <= 50; j++) {
				this.tab[i][j] = 0;
			}
		}
		
		this.nbaris = 0;
		this.nkolom = 0;
	}
	
	void IsiMatriks() { //Jangan lupa bikin kasus kalo yang di input lebih dari maks
		Scanner in = new Scanner(System.in);
		int i,j;
		
		System.out.print("Masukan jumlah baris matriks: ");
		this.nbaris = in.nextInt();
		System.out.print("Masukan jumlah kolom matriks: ");
		this.nkolom = in.nextInt();
		
		for(i = 1; i <= this.nbaris; i++) {
			for(j = 1; j <= this.nkolom; j++) {
				this.tab[i][j] = in.nextFloat();
			}
		}
	}
	
	void TulisMatriks(int n, int m) {
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				System.out.print(this.tab[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	void TukarBaris(int i1, int i2) {
		float temp;
		
		for(int j = 1; j <= this.nkolom; j++) {
			temp = this.tab[i1][j];
			this.tab[i1][j] = this.tab[i2][j];
			this.tab[i2][j] = temp;
		}
	}
	
	void KaliBaris(int i, int x) {
		for(int j = 1; j <= this.nkolom; j++) {
			this.tab[i][j] *= x;
		}
	}
	
	void TambahBarisLain(int i1, int i2, int x) {
		for(int j = 1; j <= this.nkolom; j++) {
			this.tab[i1][j] += x*(this.tab[i2][j]);
		}
	}
	
	void EleminasiGauss() {
		
	}
	
	void IsiMatriksInterpolasi(){
		float k;
		int n;
		
		Scanner baca= new Scanner(System.in);
		System.out.print("Masukkan n : ");
		n = baca.nextInt();
		int nbaris = n+1;
		int nkolom = n+2;
		
		for(int i=1;i<=n;i++){
			System.out.print("Masukkan X"+i);
			float x=baca.nextFloat();
			System.out.print("Masukkan Y"+i);
			float y=baca.nextFloat();
			
			k = 1;
			for(int j = 1; j <= nkolom-1; j++){
				this.tab[i][j] = k;
				k *= x;
			}
			this.tab[i][nkolom] = y;
		}
		
	}
}
