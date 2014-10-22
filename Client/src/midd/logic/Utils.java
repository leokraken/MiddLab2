package midd.logic;

import midd.datatypes.DataParse;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Utils {

	@SuppressWarnings("static-access")
	public DataParse ParseArgs(String []args){
		CommandLine cli;
		Option option_r = OptionBuilder.withArgName("opt1").hasArg().withDescription("The r option").create("r");
		Option option_d = OptionBuilder.withArgName("opt2").hasArg().withDescription("The d option").create("download");
		Option option_u = OptionBuilder.withArgName("opt3").hasArg().withDescription("The u option").create("upload");

		Options options = new Options();
		options.addOption(option_d);
		options.addOption(option_r);
		options.addOption(option_u);
		
		CommandLineParser parser = new GnuParser();
		String filename = "";
		String rename = "";
		Boolean download = false;
		try {
			cli = parser.parse(options, args);
			if(cli.hasOption("r")){
				System.out.println("Parser -r detected.");
				rename = cli.getOptionValue("r");	
				System.out.println(rename);
			}
			if(cli.hasOption("download")){
				System.out.println("Parser -d detected.");
				filename = cli.getOptionValue("download");	
				System.out.println(filename);
				download = true;
			}
			if(cli.hasOption("upload")){
				System.out.println("Parser -upload detected.");
				filename = cli.getOptionValue("upload");	
				System.out.println(filename);
				download = false;
			}
			String[] remainder = cli.getArgs();
            System.out.print("Remaining arguments: ");
            for (String argument : remainder)
            {
                System.out.print(argument);
                System.out.print(" ");
            }
			System.out.println();
			
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		DataParse parse =  new DataParse();
		parse.setFileName(filename);
		parse.setDownload(download);
		if(rename.equals(""))
			rename = filename;
		parse.setFileRename(rename);
		return parse;
	}
}
