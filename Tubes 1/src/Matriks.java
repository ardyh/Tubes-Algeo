import java.util.Scanner;

public class Matriks {
	int nbaris;
	int nkolom;
	float[][] tab = new float[55][55];
	float[] nilai = new float[55];
	boolean[] isUnik = new boolean[55];
	
	public Matriks() { //Konstruktor
		int i, j;
		
		for(i = 1; i <= 50; i++) {
			for(j = 1; j <= 50; j++) {
				this.tab[i][j] = 0;
			}
			this.isUnik[i] = false;
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
	
	void CopyMatriks(Matriks M2) {
		this.nbaris = M2.nbaris;
		this.nkolom = M2.nkolom;
		
		for(int i = 1; i <= this.nbaris; i++ ) {
			for(int j = 1; j <= this.nkolom; j++) {
				this.tab[i][j] = M2.tab[i][j];
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
	
	void KaliBaris(int i,float d) {
		for(int j = 1; j <= this.nkolom; j++) {
			this.tab[i][j] *= d;
		}
	}
	
	void TambahBarisLain(int i1, int i2, float x) {
		for(int j = 1; j <= this.nkolom; j++) {
			this.tab[i1][j] += x*(this.tab[i2][j]);
		}
	}
	
	void EleminasiGauss() {
		int i, j, k;
		
		i = 1;
		j = 1;
		//Memastikan 1 utamanya bisa diakalin
		while((i <= this.nbaris) && (j < this.nkolom)) {
			
			if(this.tab[i][j] == 0) {
				k = i;
			
				while((j < this.nkolom) && (this.tab[k][j] == 0)) {
					k++;
					if(k > this.nbaris) {
						k = i;
						j++;
					}
				}
				
				if(j < this.nkolom) {
					this.TukarBaris(i, k);
					this.KaliBaris(i, (1/this.tab[i][j]));
					this.isUnik[j] = true;
					for(k = i+1; k <= this.nbaris; k++) {
						this.TambahBarisLain(k, i, (-(this.tab[k][j])/(this.tab[i][j])));
					}
					i++;
					j++;
				}
			} else {
				this.KaliBaris(i, (1/this.tab[i][j]));
				this.isUnik[j] = true;
				for(k = i+1; k <= this.nbaris; k++) {
					this.TambahBarisLain(k, i, (-(this.tab[k][j])/(this.tab[i][j])));
				}
				i++;
				j++;
			}
		}
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
	
	void EleminasiGaussJordan() 
	{
		int i, j, k;
		
		i = 1;
		j = 1;
		//Memastikan 1 utamanya bisa diakalin
		while((i <= this.nbaris) && (j < this.nkolom)) {
			
			if(this.tab[i][j] == 0) {
				k = i;
			
				while((j < this.nkolom) && (this.tab[k][j] == 0)) {
					k++;
					if(k > this.nbaris) {
						k = i;
						j++;
					}
				}
				
				if(j < this.nkolom) {
					this.TukarBaris(i, k);
					this.KaliBaris(i, (1/this.tab[i][j]));
					this.isUnik[j] = true;
					for(k = i+1; k <= this.nbaris; k++) {
						this.TambahBarisLain(k, i, (-(this.tab[k][j])/(this.tab[i][j])));
					}
					for(k = i-1; k >= 1; k--) {
						this.TambahBarisLain(k, i, (-(this.tab[k][j])/(this.tab[i][j])));
					}
					i++;
					j++;
				}
			} else {
				this.KaliBaris(i, (1/this.tab[i][j]));
				this.isUnik[j] = true;
				for(k = i+1; k <= this.nbaris; k++) {
					this.TambahBarisLain(k, i, (-(this.tab[k][j])/(this.tab[i][j])));
				}
				for(k = i-1; k >= 1; k--) {
					this.TambahBarisLain(k, i, (-(this.tab[k][j])/(this.tab[i][j])));
				}
				i++;
				j++;
			}
		}
	}
	
	boolean NoSolusi(){
		int i,j;
		boolean telusur=false;
		i=this.nbaris;
		j = 0;
		while ((i>=1)&&(!telusur)){
			j=0;
			while((j<this.nkolom)&&(!telusur)){
				j++;
				if (this.tab[i][j]!=0) {
					telusur=true;
				}
			}
			if ((!telusur)&&(this.tab[i][j]!=0)){
				telusur=true;
			}		
			i--;
		}
		
		if ((j < this.nkolom)||(i<1)){
			return false;
		}
		else{
			return true;
		}
		
	}
	
	boolean SolusiUnik() {
		int i,j;
		boolean cek;
		
		i = 1;
		cek = this.isUnik[1];
		while((cek) && (i < this.nkolom-1)) {
			i++;
			cek = this.isUnik[i];
		}
		return cek;
	}
	
	void Solusi() {
		
		
		if(this.NoSolusi()) {
			System.out.println("Solusi tidak ada");
		}
		else if(this.SolusiUnik()) {
			System.out.println("Solusi ada");
		}
		else {
			System.out.println("Solusi parametrik"); //Nanti ubah lagi
		}
	}
}	
