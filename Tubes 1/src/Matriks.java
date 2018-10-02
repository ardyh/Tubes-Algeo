import java.util.Scanner;
public class Matriks {
	int nbaris;
        int n;
	int nkolom;
	float[][] tab = new float[55][55];
	float[] nilai = new float[55];
	boolean[] isUnik = new boolean[55];
	char[][] vrbl = new char[55][55];
        float[][] cons = new float[55][55];
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
	
        int hapusNolSemua(){
		int i;
                int cnt=0;
                for(int a=1;a<=this.nbaris;a++){
                    boolean telusur=true;
                    i=1;
                    while ((telusur)&&(i<=this.nkolom)){
                        if(this.tab[a][i]!=0){
                            telusur=false;
                        }
                        i++;
                    }
                    if(telusur){
                        cnt++;
                    }
                }
                return cnt;
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
	void IsiMatriksInterpolasi(){
		float k;
		
		Scanner baca= new Scanner(System.in);
		System.out.print("Masukan n : ");
		n = baca.nextInt();
		this.nbaris = n+1;
		this.nkolom = n+2;
		
		for(int i=1;i<=n+1;i++){
			System.out.print("Masukan X"+i+" : ");
			float x=baca.nextFloat();
			System.out.print("Masukan Y"+i+" : ");
			float y=baca.nextFloat();
			
			k = 1;
			for(int j = 1; j <= nkolom-1; j++){
				this.tab[i][j] = k;
				k *= x;
			}
			this.tab[i][nkolom] = y;
		}
		
	}
           
        void InterpolasiGaussJordan(){
		int i, j, k;
		i = 1;
		j = 1;
    
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
						this.TambahBarisLain(k, i, ((-1)*(this.tab[k][j])/(this.tab[i][j])));
					}
					for(k = i-1; k >= 1; k--) {
						this.TambahBarisLain(k, i, ((-1)*(this.tab[k][j])/(this.tab[i][j])));
					}
					i++;
					j++;
				}
			} else {
				this.KaliBaris(i, (1/this.tab[i][j]));
				this.isUnik[j] = true;
				for(k = i+1; k <= this.nbaris; k++) {
					this.TambahBarisLain(k, i, ((-1)*(this.tab[k][j])/(this.tab[i][j])));
				}
				for(k = i-1; k >= 1; k--) {
					this.TambahBarisLain(k, i, ((-1)*(this.tab[k][j])/(this.tab[i][j])));
				}
				i++;
				j++;
			}
		}
                if(SolusiUnik()){
                   i=this.nbaris;
                   j=this.nkolom-1;
                   while((i>=1) && (j>=1)){
                       nilai[i]=tab[i][this.nkolom];
                               i--;
                               j--;
                               
                   }
                } else {
                    System.out.println("Solusi tidak ada");
                }
        }
        
        void InterpolasiGauss(){
		int i, j, k;
                float hasil;
		i = 1;
		j = 1;
                
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
						this.TambahBarisLain(k, i, ((-1)*(this.tab[k][j])/(this.tab[i][j])));
					}
					i++;
					j++;
				}
			} else {
				this.KaliBaris(i, (1/this.tab[i][j]));
				this.isUnik[j] = true;
				for(k = i+1; k <= this.nbaris; k++) {
					this.TambahBarisLain(k, i, ((-1)*(this.tab[k][j])/(this.tab[i][j])));
				}
				i++;
				j++;
			} 
		} 

               if(SolusiUnik()){
                   i=this.nbaris;
                   while(i>=1){
                       j=this.nkolom-1;
                       hasil=tab[i][this.nkolom];
                       
                       while(j>i){
                           hasil = hasil-nilai[j]*tab[i][j];
                           j--;
                       }
                       nilai[i]=hasil;
                       i--;
                   }
               } else {
                   System.out.println("Solusi tidak ada");
               }
        }
	
        void Fx(){
            float hasil,k;
            int j,x;
            hasil=0;
            k=1;
            Scanner in= new Scanner(System.in);
            System.out.print("Masukan x : ");
            x = in.nextInt();   
            for(j=1;j<=this.nkolom-1;j++){
                hasil=hasil+nilai[j]*k;
                k=k*x;
            }
            System.out.print("hasil F(x) untuk x = "+x+" adalah ");
            System.out.println(hasil);
        
        }
        
        
        void representasiInterpolasi(){
            int j,a;
            a=this.nkolom-2;
            j=this.nkolom-1;
            System.out.println("Polinom F(x) yang terbentuk : ");
            while(j>=1){
                System.out.print(this.nilai[j]);
                System.out.print("X^"+a);
                
                if(j!=1){
                     if(this.nilai[j-1]>=0){
                        System.out.print("+");
                     }
                } else {
                    System.out.println(" = 0");
                }
                a--; 
                j--;
            }
     
        }
        void inisialisasiVar(){
            int cnt=0;
            char x='A'-1;
            for(int i=1;i<this.nkolom;i++){
                if (this.isUnik[i]){
                    this.nilai[i]=this.tab[i-cnt][this.nkolom];
                    this.vrbl[i][1]='.';
                    this.cons[i][1]=0;
                } else{
                    cnt++;
                    x++;
                    this.nilai[i]=0;
                    this.vrbl[i][1]=x;
                    this.cons[i][1]=1;
                    this.vrbl[i][2]='.';
                    this.cons[i][2]=0;
                }
            }
        }
        void Carisolusi(){
            int cnt=0;
            int j,k,l,x;
            cnt=this.hapusNolSemua();
            for(int i=this.nkolom-1;i>=1;i--){
                if(this.isUnik[i]){
                    cnt++;
                    j=i+1;
                    x=this.nbaris-cnt+1;
                    //System.out.print(i+"  "+x);
                    while(j<this.nkolom){
                        this.nilai[i]=this.nilai[i]+(-this.tab[x][j]*this.nilai[j]);
                        k=1;
                        //ganti nilai vrbl kalau ada
                        while(this.vrbl[j][k]!='.'){
                            l=1;
                            //search vrbl
                            while((this.vrbl[i][l]!=this.vrbl[j][k])&&(this.vrbl[i][l]!='.')){
                                l++;
                            }
                            if(this.vrbl[i][l]=='.'){
                                this.vrbl[i][l]=this.vrbl[j][k];
                                this.cons[i][l]=this.cons[j][k]*(-this.tab[x][j]);
                                this.vrbl[i][l+1]='.';
                                this.cons[i][l+1]=0;
                            }else{
                                this.cons[i][l]=this.cons[i][l]+this.cons[j][k]*(-this.tab[x][j]);
                            }
                            k++;
                        }
                        j++;
                    }
                }
            }    
        }
        void printsolusi(){
            int j;
            boolean udah;
            for(int i=1;i<=this.nkolom-1;i++){
                udah=false;
                System.out.print("X["+i+"] = ");
                if(this.nilai[i]!=0){        
                    System.out.print(this.nilai[i]);
                    udah=true;
                }
                j=1;
                while(this.vrbl[i][j]!='.'){
                    if(this.cons[i][j]>0){
                        if(this.cons[i][j]!=1){
                            if(this.nilai[i]!=0){
                                System.out.print("+"+this.cons[i][j]);
                            }else{
                                System.out.print(this.cons[i][j]);
                            }
                        }
                        if((this.cons[i][j]==1)&&(this.nilai[i]!=0)){
                            System.out.print("+");
                        }
                        System.out.print(this.vrbl[i][j]);
                        udah=true;
                    }else if(this.cons[i][j]<0){
                        if(this.cons[i][j]==-1){
                            System.out.print('-');
                        }else{
                            System.out.print(this.cons[i][j]);
                        }
                        System.out.print(this.vrbl[i][j]);
                        udah=true;
                    }
                    j++;
                }
                 if((this.nilai[i]==0)&&(!udah)){
                    System.out.print(this.nilai[i]);
                 }
                System.out.println();
            }
        }
        void Solusi() {		
            if(this.NoSolusi()) {
		System.out.println("Solusi tidak ada");
            }else{
                this.inisialisasiVar();
                this.Carisolusi();
                this.printsolusi();
            }
	}
        public static void main(String[] args) {
		// TODO Auto-generated method stub
         
		Matriks M1 = new Matriks();
                M1.IsiMatriks();
                M1.EleminasiGauss();
                M1.Solusi();
               // System.out.println(M1.nilai[1]);
              /*M1.IsiMatriksInterpolasi();
                M1.TulisMatriks(M1.nbaris, M1.nkolom);
                M1.InterpolasiGauss();
                M1.TulisMatriks(M1.nbaris, M1.nkolom);
                M1.representasiInterpolasi();
                M1.Fx();*/
                
	/*	M1.IsiMatriksInterpolasi();
                M1.TulisMatriks(M1.nbaris, M1.nkolom);
		M1.InterpolasiGauss();
                M1.representasiInterpolasi();
          	M1.InterpolasiGaussJordan();
                M1.representasiInterpolasi();
                M1.Fx();
 	}*/
}
