package edu.umb.cs680.hw03;

public enum StudentStatus {
	INSTATE{
		@Override public float getTuition()
		{
			return 1000;
		}
	},
	OUTSTATE{
		@Override public float getTuition()
		{
			return 3000;
		}
	},
	INTL{
		@Override public float getTuition()
		{
			return 5000;
		}
	};
	
public float getTuition()
	{
		return 0;
	}
}
