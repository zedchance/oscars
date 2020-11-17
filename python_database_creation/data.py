import sqlite3
from prettytable import from_db_cursor
import csv
import sys

conn =sqlite3.connect('movies_backup.sqlite')
cur=conn.cursor()
#----delete the empty value from the table
sys.stdout=open("data.txt","w")
cur.execute('''CREATE TABLE movies1 AS SELECT title,json FROM movies''')
cur.execute("DROP TABLE movies")
cur.execute("ALTER TABLE movies1 RENAME TO movies")
#----select and print out the value from thetable
#cur.execute("update movies set json=json || json1 ")
cur.execute("SELECT * FROM movies")
myresult = from_db_cursor(cur)


for x in myresult:
  print(x)
conn.commit()


sys.stdout.close()