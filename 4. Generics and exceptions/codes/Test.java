class Test {

	public static void main(String[] args) {

		MySet<String> words = new MySet<String>();

		for (int i = 0; i < args.length; i++) {
			words.add(args[i]);
			// System.out.println(args[i]);
		}

		//print words directly	
		// System.out.println(words.toString());

		String st;
		while ((st = words.remove()) != null)
			System.out.println(st);
	}
}
//end