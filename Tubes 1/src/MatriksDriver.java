
public class MatriksDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub         
		Matriks M1 = new Matriks();
                System.out.println("MENU");
		System.out.println("1. Sistem Persamaan Linear");
		System.out.println("2. Interpolasi Polinom");
		System.out.println("3. Keluar");
		
		System.out.println("Pilih metode penyelesaian");
		System.out.println("1. Metode eliminasi Gauss");
		System.out.println("2. Metode eliminasi Gauss-Jordan");
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

}
