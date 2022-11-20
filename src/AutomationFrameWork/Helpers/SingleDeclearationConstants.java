package AutomationFrameWork.Helpers;

public class SingleDeclearationConstants {
    public static enum DeliveryTerm {
		CIF {
	 
		   // overriding toString() for CIF
		   public String toString() {
			 return "Cost, insurance And Freight (CIF)";
		   }
		},
	 
		CFR {
	 
		  // overriding toString() for CFR
		   public String toString() {
			 return "Cost And Freight (CFR)";
		   }
		   
		},
		FOB {
	 
			// overriding toString() for FOB
			 public String toString() {
			   return "Free On Board (FOB)";
			 }
			 
		  }
		;
	 }
    public static enum ModeofPayment{
		OpenAccount {
	 
		   // overriding toString() for OpenAccount
		   public String toString() {
			 return "Open Account";
		   }
		},
	 
		AdvancedPayment {
	 
		  // overriding toString() for AdvancedPayment
		   public String toString() {
			 return "Advanced Payment";
		   }
		   
		},
		ContractCollection {
	 
			// overriding toString() for ContractCollection
			 public String toString() {
			   return "Contract/Collection";
			 }
			 
		  },
		LetterofCredit {
	 
			// overriding toString() for LetterofCredit
			 public String toString() {
			   return "Letter of Credit";
			 }
			 
		  }
		;
	 }
    public static enum Bank{
		AlBarakaBank {
	 
		   // overriding toString() for OpenAccount
		   public String toString() {
			 return "Al Baraka Bank (Pakistan) Ltd";
		   }
		},
	 
		BankAlfalah {
	 
		  // overriding toString() for AdvancedPayment
		   public String toString() {
			 return "Bank Alfalah Ltd";
		   }
		   
		},
		DubaiIslamicBank {
	 
			// overriding toString() for ContractCollection
			 public String toString() {
			   return "Dubai Islamic Bank Pakistan Ltd";
			 }
			 
		  },
          SoneriBank {
	 
			// overriding toString() for LetterofCredit
			 public String toString() {
			   return "Soneri Bank Ltd";
			 }
			 
		  }
		;
	 }
	public enum Currency{
		AustralianDollar {
	 
		   // overriding toString() for OpenAccount
		   public String toString() {
			 return "Aus $";
		   }
		},
	 
		ThailandBaht {
	 
		  // overriding toString() for AdvancedPayment
		   public String toString() {
			 return "Baht";
		   }
		   
		},
		CanadianDollar {
	 
			// overriding toString() for ContractCollection
			 public String toString() {
			   return "Canadian Dollar";
			 }
			 
		  },
          DanishKroner {
	 
			// overriding toString() for LetterofCredit
			 public String toString() {
			   return "Danish Kroner";
			 }
			 
		  }, 
          Euro {
	 
			// overriding toString() for LetterofCredit
			 public String toString() {
			   return "Euro";
			 }
			 
		  }, 
          HongKongDollar {
	 
			// overriding toString() for LetterofCredit
			 public String toString() {
			   return "Hong Kong Dollar";
			 }
			 
		  }, 
          KuwaitiDinar {
	 
			// overriding toString() for LetterofCredit
			 public String toString() {
			   return "Kuwaiti Dinar";
			 }
			 
		  }, 
          MalaysianRinggit {
	 
			// overriding toString() for LetterofCredit
			 public String toString() {
			   return "Malaysian Ringgit";
			 }
			 
		  }, 
          NorKrone {
	 
			// overriding toString() for LetterofCredit
			 public String toString() {
			   return "Nor.Krone";
			 }
			 
		  }, 
          NewZealandDollar {
	 
			// overriding toString() for LetterofCredit
			 public String toString() {
			   return "Nz $";
			 }
			 
		  }
          , 
          PakistanRupee {
	 
			// overriding toString() for LetterofCredit
			 public String toString() {
			   return "Pakistan Rupee";
			 }
			 
		  }
          , 
          BritishPound {
	 
			// overriding toString() for LetterofCredit
			 public String toString() {
			   return "Pound";
			 }
			 
		  }
          , 
          QatariRial {
	 
			// overriding toString() for LetterofCredit
			 public String toString() {
			   return "Qatari Rial";
			 }
			 
		  }
          , 
          SwissFranc {
	 
			// overriding toString() for LetterofCredit
			 public String toString() {
			   return "S.Fr";
			 }
			 
		  }
          , 
          SaudiRiyal {
	 
			// overriding toString() for LetterofCredit
			 public String toString() {
			   return "Saudi Riyal";
			 }
			 
		  }
          , 
          SingaporeDollar {
	 
			// overriding toString() for LetterofCredit
			 public String toString() {
			   return "Singapore Dollar";
			 }
			 
		  }
          , 
          SwedishKrona {
	 
			// overriding toString() for LetterofCredit
			 public String toString() {
			   return "Swedish Krona";
			 }
			 
		  }
          , 
          UAEDirham {
	 
			// overriding toString() for LetterofCredit
			 public String toString() {
			   return "UAE Dirham";
			 }
			 
		  }
          , 
          UnitedStatesDollar {
	 
			// overriding toString() for LetterofCredit
			 public String toString() {
			   return "United States Dollar";
			 }
			 
		  }
          , 
          SouthKoreanWon {
	 
			// overriding toString() for LetterofCredit
			 public String toString() {
			   return "Won";
			 }
			 
		  }
          , 
          JapaneseYen {
	 
			// overriding toString() for LetterofCredit
			 public String toString() {
			   return "Yen";
			 }
			 
		  }
          
		;
	 }
	public static enum ConsignmentCategory {
		Commercial {
	 
		   public String toString() {
			 return "Commercial";
		   }
		};
	 }
	public static enum DeclarationType
	 {
		ExportCommercialTransaction
		{
			public String toString()
			{
				return "Export Commercial Transaction";
			}

		}

	 }
	public static enum Collectorate
	{
		PortQasimExportKarachi
		{
			public String toString()
			{
				return "Port Qasim (exports), karachi";
			}
		}
	} 
	public static enum 	ConsignmentMode
	{
		Containerized
		{
			public String toString()
			{
				return "Containerized";
			}

		}
	}
	public static enum Shed
	{
		QasimInternationalContainerTerminal
		{
			public String toString()
			{
				return "Qasim International Container Terminal";
			}
		}
	}
	public static enum Terminal
	{
		QasimInternationalContainerTerminal
		{
			public String toString()
			{
				return "Qasim International Container Terminal";
			}

		}

	}


	/////////AMENDMENT//////////

	}
