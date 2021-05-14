CFLAGS 		= -g -O1 -Wall -Wextra -Wpedantic -Wconversion
COMMON_DEPS 	= src/*.h Makefile

all: createdir bin/client bin/edit_distance_unit_test

client: createdir bin/client

test: createdir bin/edit_distance_unit_test

createdir:	
	mkdir bin -p
	mkdir build -p

build/%.o: src/%.c $(COMMON_DEPS)
	gcc $(CFLAGS) -c $< -o $@

bin/client: build/parser.o build/edit_distance.o build/mybst.o build/client.o $(COMMON_DEPS)
	gcc -o bin/client build/parser.o build/edit_distance.o build/mybst.o build/client.o

bin/edit_distance_unit_test: build/edit_distance.o build/edit_distance_unit_test.o build/unity.o $(COMMON_DEPS)
	gcc -o bin/edit_distance_unit_test build/edit_distance.o build/unity.o build/edit_distance_unit_test.o
clean:
	$(RM) build/*
	$(RM) bin/*
