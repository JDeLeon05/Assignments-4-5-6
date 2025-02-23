import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;


public class Matrix{
    //variables
    int rows;
    int matrix1[][];
    int matrix2[][];
    int Matrix3[][];

    String file1;
    String file2;
    
    
    Scanner scnr = new Scanner(System.in);
    public void main(String args[]){
        Commands();   
    }

    public void Commands(){
        //introduces character to the program
        System.out.println("==============================================");
        System.out.println("Welcome to Matrix!");
        System.out.println("In this program, you can write and read files that store matrices of numbers.");
        System.out.println(" ");
        System.out.println("To begin, ");
        
        while (1 == 1) {
            //user is given options to read or write a file
            System.out.println("simply enter 'write' to write files ");
            System.out.println("or 'read' to read them,");
            System.out.print("or 'end' to stop the program, then press ENTER: ");

            //response is lowercased and whitespace is removed so small errors don't effect outcome
            String input = scnr.next();
            input = input.replaceAll("\\s+", "");
            input = input.toLowerCase();

            if(input.equals("write")){

                //user inputs how many rows they'd like
                System.out.print("enter the rows: ");
                rows = scnr.nextInt();

                System.out.println("2 matrices have now been created and stored in Matrix1 and Matrix2 files");
                //2 random matrixes are created and stored into 2 different files
                createFile(rows, "Matrix1.txt");
                createFile(rows, "Matrix2.txt");

                //the matrixes are stored into 2 different variables
                matrix1 = readFile("Matrix1.txt").clone();
                matrix2 = readFile("Matrix2.txt").clone();

                //the 2 matrixes are combined and stored in a 3rd file
                Matrix3 = combineFiles(matrix1, matrix2, rows).clone();

                //user is told about the 3rd matrix
                System.out.println("they have also been combined to create the 3rd matrix below:");
                System.out.println("");

                //3rd matrix is printed out
                for(int i = 0; i < matrix1.length*2; i++){
                    for(int j = 0; j < matrix1.length; j++){
                        System.out.print(Matrix3[i][j]);
                    }
                    System.out.println("");
                }

            } else if(input.equals("read")){
                
                System.out.println("");
                System.out.println("Our following files are listed below,");

               while(1==1){
                    //user is given files they can read
                    System.out.println("please type the name of the file you'd like to use and press enter:");
                    System.out.println("Matrix1");
                    System.out.println("Matrix2");
                    System.out.println("Matrix1Matrix2");

                    //user inputs file they'd like to read
                    input = scnr.next();
                    System.out.println("");

                    //answer is lowercased and white spaces are removed to remove any small differences
                    input = input.replaceAll("\\s+", "");
                    input = input.toLowerCase();

                    //Matrix 1 is read
                    if(input.equals("matrix1")){
                        //Matrix1 file is extracted and stored into a variable
                        matrix1 = readFile("Matrix1.txt").clone();

                        //the matrix is printed out so the user can see
                        System.out.println("The value of Matrix1 is the following matrix:");
                        for(int i = 0; i < matrix1.length; i++){
                            for(int j = 0; j < matrix1.length; j++){
                                System.out.print(matrix1[i][j]);
                            }
                            System.out.println("");
                        }
                        
                        break;

                    } else if(input.equals("matrix2")){
                        //Matrix 2 file is extracted & stored into variable
                        matrix2 = readFile("Matrix2.txt").clone();

                        //contents of matrix2 are printed outto the player
                        System.out.println("The value of Matrix2 is the following matrix:");
                        for(int i = 0; i < matrix2.length; i++){
                            for(int j = 0; j < matrix2.length; j++){
                                System.out.print(matrix2[i][j]);
                            }
                            System.out.println("");
                        }

                        break;
                    } else if(input.equals("matrix1matrix2")){

                        //Matrix1 and Matrix2 are extracted and stored in variables
                        matrix1 = readFile("Matrix1.txt").clone();
                        matrix2 = readFile("Matrix2.txt").clone();

                        //both matrixes are combined and stored into a Matrix3 file & variable
                        Matrix3 = combineFiles(matrix1, matrix2, matrix1.length).clone();

                        //Matrix 3 is printed so the player can see
                        System.out.println("Both matrix 1 & 2 have been combined to create the following 3rd matrix:");

                        for(int i = 0; i < matrix1.length*2; i++){
                            for(int j = 0; j < matrix1.length; j++){
                                System.out.print(Matrix3[i][j]);
                            }
                            System.out.println("");
                        }

                        break;

                    } else {

                        System.out.println("Your answer did not match any of our options");

                    } //end if

                }//end while
               
            } else if(input.equals("end")){
                //program ends if user inputs "end"
                System.out.println("Thanks for playing!");
                break;
            } else {

                //program asks user to re-enter an input because it wasn't one of the options
                System.out.println("please be sure your answer is one of the following options");
                System.out.println("  ");

            }//end else

            System.out.println("");
            System.out.print("Would you like to go again? if so, ");
        }//end while

    }

    public void createFile(int x, String name) {
        //variables
        int mat[][] = new int[x][x];

        //assigns random values to a matrix
        for (int i = 0; i < x; i++ ) {
            String output = "";
            for( int j = 0; j < x; j++){
                mat[i][j] = (int)(Math.random() * 10);
                output += Integer.toString(mat[i][j]);
            
            }
            
        }      

        //stores value into Matrix1 or Matrix2 file
        try(BufferedWriter bfr = new BufferedWriter(new FileWriter(name))){     
            for(int i = 0; i < mat.length; i++)   {

                for (int j = 0; j < mat.length; j++){

                    bfr.write(Integer.toString(mat[i][j]) + " ");
                    
                }
                
                bfr.newLine();
            }
            
        } catch(Exception e){
            System.out.println("there was an error: " + e);
        }
    }

    //following method extracts a file and returns a matrix
    public int[][] readFile(String name) {
        try(BufferedReader bfr = new BufferedReader(new FileReader(name))){
            //since its a square matrix, 1st line is read to determine the length of the matrix
            String line = bfr.readLine();
            String wholeMatrix = line;
            char[] lineArray;

            //matrix variable is created
            int matrix[][] = new int[(line.length()/2)][(line.length()/2)];

            //file is stored into a string variable
            while(line != null){
                line = bfr.readLine();
                if(line == null){
                    continue;
                }
                wholeMatrix += line;
            }

            //string is trimed and stored into an array of characters
            wholeMatrix = wholeMatrix.replaceAll("\\s+", "");
            lineArray = wholeMatrix.toCharArray();

            //each character is then stored into a matrix of integers
            int a = 0;
            for (int i = 0; i < matrix.length; i++){
                for(int j = 0; j < matrix.length; j++){

                    matrix[i][j] = Character.getNumericValue(lineArray[a]);
                    a++;
                    
                }
                
            }
            
            //final matrix is returned
            return matrix;

        } catch(Exception e){
            System.out.println(e);
        }
        return null;
    }

    //method combines 2 matrixes and returns the result
    public int[][] combineFiles(int[][] mat1, int[][] mat2, int rowSize){
        try(BufferedWriter bfr = new BufferedWriter(new FileWriter("Matrix3.txt"))){
            //3rd matrix is created, since it's a combination of matrixes, it's heights is twice the length
            int[][] mat3 = new int[rowSize*2][rowSize];

            //the values of matrix1 are copied the 3rd matrix
            for(int i = 0; i < rowSize; i++){
                for(int j = 0; j < rowSize; j ++) {
                    mat3[i][j] = mat1[i][j];
                }
            }

            //values of matrix 2 are copied to matrix
            int a = 0;
            for(int i = rowSize; i < rowSize * 2; i++){
                for(int j = 0; j < rowSize; j++){
                    mat3[i][j] = mat2[a][j];
                    
                }
                a++;
               
            }

            //3rd matrix is transfered to a different file
            for(int i = 0; i < rowSize * 2; i++){
                for( int j = 0; j < rowSize; j++){
                    bfr.write(Integer.toString(mat3[i][j]) + " ");
                    
                }
                
                bfr.newLine();
            }

            //final matrix is returned
            return mat3;
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }
}