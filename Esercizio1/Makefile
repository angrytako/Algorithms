CFLAGS 		= -g -O1 -Wall -Wextra -Wpedantic -Wconversion
COMMON_DEPS 	= src/*.h Makefile

all: createdir bin/client bin/sort_unit_test

client: createdir bin/client

test: createdir bin/sort_unit_test

createdir:	
	mkdir bin -p
	mkdir build -p

build/%.o: src/%.c $(COMMON_DEPS)
	gcc $(CFLAGS) -c $< -o $@

bin/client: build/parser.o build/validation.o build/sort.o build/client.o $(COMMON_DEPS)
	gcc -o bin/client build/parser.o build/validation.o build/sort.o build/client.o

bin/sort_unit_test: build/sort.o build/sort_unit_test.o build/unity.o $(COMMON_DEPS)
	gcc -o bin/sort_unit_test build/sort.o build/unity.o build/sort_unit_test.o
clean:
	$(RM) build/*
	$(RM) bin/*
