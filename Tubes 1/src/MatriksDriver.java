
public class MatriksDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Matriks M1 = new Matriks();
		M1.IsiMatriks();
		M1.TulisMatriks(M1.nbaris, M1.nkolom);
		M1.TukarBaris(2, 3);
		M1.TulisMatriks(M1.nbaris, M1.nkolom);
		M1.KaliBaris(1, 4);
		M1.TulisMatriks(M1.nbaris, M1.nkolom);
		M1.TambahBarisLain(1, 2, 2);
		M1.TulisMatriks(M1.nbaris, M1.nkolom);
 	}

}
