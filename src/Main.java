import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Main {

	public static void main(String[] args) {

		// Création du contrôleur

		Control controler = new Control();

		// Création de notre fenêtre avec le contrôleur en paramètre

		Vue vue = new Vue(controler);


	}

}
