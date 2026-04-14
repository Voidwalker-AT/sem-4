import pandas as pd

df=pd.read_csv("extremely_messy_superstore_data.csv")
print("Initial Total Rows:",len(df))

missing_counts=df.isnull().sum()
print("Missing Values in Each Column:")
print(missing_counts[missing_counts>0])

df_cleaned=df.dropna()
print("Rows remaining after dropping missing values:",len(df_cleaned))

#check and display the total number of duplicate rows
duplicate_count = df_cleaned.duplicated().sum()
print("Total Duplicates Found:",duplicate_count)

df_cleaned=df_cleaned.drop_duplicates()
print("Rows remaining after dropping duplicates:",len(df_cleaned))

df_cleaned.to_csv("my_final_cleaned_superstore.csv", index=False)
print("Data cleaning completed. Cleaned dataset saved as 'my_final_cleaned_superstore.csv'.")

