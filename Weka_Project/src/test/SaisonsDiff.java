package test;

import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class SaisonsDiff {

	public SaisonsDiff() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		
		int annee = 2008;
		for(int i=0; i<=9; i++) {
			
			System.out.println("jeu de "+annee);
			
			annee++;
			
			// NaiveBayes
			try {
				
				DataSource source = new DataSource("C:/Users/leo22/Documents/DUT/2A/4S/3-TP-Fouille de données/donnees-basket/arffs/"+annee+"/gamesAdvancedStats-StdDevs-noPointDifferential-noNames.arff");
				NaiveBayes NB = new NaiveBayes();
				String[] options = new String[1];
				
				Instances data = source.getDataSet();
				
				if(data.classIndex()==-1)
					data.setClassIndex(data.attribute("outcomeForFirst").index());
				
				options[0] = "-K";
				NB.setOptions(options);
				NB.buildClassifier(data);
				
				Evaluation eval = new Evaluation(data);
				eval.evaluateModel(NB, data);
				
				System.out.println(eval.pctCorrect());
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}

}
