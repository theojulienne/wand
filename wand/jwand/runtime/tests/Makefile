CFLAGS=-I../ -Wall -g
RUNTIME_OBJS=../object.o

all: classtest

classtest: classtest.c $(RUNTIME_OBJS)
	gcc -o classtest classtest.c $(RUNTIME_OBJS) $(CFLAGS)