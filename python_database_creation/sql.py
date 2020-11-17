import sqlite3
import csv
import sys

check=[]
conn =sqlite3.connect('movies_backup.sqlite')
cur=conn.cursor()
#-------initailize the table 
cur.execute('DROP TABLE IF EXISTS movies')
cur.execute('''
CREATE TABLE "movies" (
    "title" TEXT,
    "json" TEXT,
    "json1" TEXT

)
''')
fname=input('Enter the movies csv file name: ')
if (len(fname))<1:
        fname="KaggleData_the_oscar_award.csv"   
with open(fname) as csv_file:
    csv_reader= csv.reader(csv_file, delimiter=',')
    sys.stdout=open("data.txt","w")
    for row in csv_reader:
        title=row[0].replace(";","")
        year=row[1]
        ceremony=row[2]
        award_category=row[3]
        award_name=row[4]
        award_winner=row[5]
    #-------manipulate the value from csv before putting to the sql table
        du="{\"title\": "+"\""+ title+"\","+"\"year\": "+"\""+year+"\","+"\"ceremony\": "+"\""+ceremony+"\","+"\"awards\": ["
        de="{\"category\": "+"\""+award_category+"\","+"\"name\": \""+award_name+"\","+"\"winner\": "+award_winner.lower()+"}"
        gg=""
        if title in check:
            gg=('{"category": "%s","name": "%s","winner": %s}' %(award_category,award_name,award_winner.lower()))
            cur.execute(""" UPDATE movies SET json1= json1 || ',' || (?) where title like (?) """, (gg,"%"+title+"%"))
            #cur.execute("SELECT title FROM movies where title like (?) ", (title,))
        else:
            if title != "":
                cur.execute(''' INSERT INTO movies (title,json,json1)
                    VALUES (?,?,?)''', (title,du,de))
                check.append(title)
            else:
                cur.execute(''' INSERT INTO movies (title,json,json1)
                    VALUES (?,?,?)''', (title,du,de))
        conn.commit()
    sys.stdout.close()