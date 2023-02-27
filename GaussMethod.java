package com.company;

import static java.lang.Math.abs;

public class GaussMethod { //Решение уравнений методом Гаусса
    private static int[][] indexMass;

    public static void setIndexMass(int size) {
        indexMass = new int[size][size+1];
    }

    public static double getDeterminant(double[][] a)
    {
        double det = 1;
        int size = a.length;
        for(int i = 0; i < size; i++)
            det = det * a[i][i];

        return det;
    }

    public static double[] getRootsNew(double[][] matrix)
    {
        int n = matrix.length;
        double s = 0;
        double[] x = new double[n];

        x[n-1] = matrix[n-1][n] / matrix[n-1][n-1];
        // ma tran bac thang nen tinh tu gia tri cuoi cung len
        for (int i = n - 2 ; i >= 0 ; i --)
        {
            // gan gia tri cua s  = 0;
            s = 0;
            for (int k = i + 1 ; k < n; k++)
            {
                // lay gia cua s = gia tri cua cac phan tu cua hang
                s = s + matrix[i][k] * x[k];
                x[i] = ( matrix[i][n]- s ) / matrix[i][i];
            }
        }
        return x;
    }

    public static double[] getDiscrepancyNew(double[][] matrix, double[] x)
    {
        int n = matrix.length;
        double[] dis = new double[n];

        for(int i = 0; i < n; i++){
            double r = matrix[i][n];
            for(int j = 0; j < n; j++){
                r -= matrix[i][j]*x[j];
            }

            dis[i] = r;
        }
        return dis;
    }

    public static void printMtx(double[][] a)
    {
        int n = a.length;
        for (int i = 0 ; i < n ; i++ )
        {
            for (int j = 0 ; j <= n ; j++ ){
                System.out.printf("%.2f\t", (double)Math.round(a[i][j] * 1000) / 1000);
            }


            System.out.println();
        }
        System.out.println();
    }

    public static double[][] getTriangleNew(double[][] matrix)
    {
        int n = matrix.length;
        for (int k = 0 ; k < (n - 1) ; k++)
            for ( int i = k + 1 ; i < n; i++) {
                if (matrix[k][k] != 0) {
                    // lay phan tu cua hang chia cho gia tri o chinh giua

                    double c = matrix[i][k] / matrix[k][k];
                    // lay hang  sau tru di hang  truoc  voi cac phan tu tuong ung
                    for (int j = 0; j <= n; j++) {
                        // lay hang sau tru di hang truoc tuong ung voi 1 cot
                        matrix[i][j] = matrix[i][j] - (matrix[k][j] * c);

                    }
                }
            }
        if (matrix[n-1][n-1] == 0 )
        {
            // khi gia tri cua b bang 0 thi he co vo so nghiem
            if ( matrix[n-1][n] == 0 )
                return null;
        }
        return matrix;
    }
}