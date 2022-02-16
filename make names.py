import names
textfile=open("studentID.txt", "w+")
for i in range(1000):
    textfile.write(str(i)+" "+str(names.get_full_name())+"\n")
textfile.close()
