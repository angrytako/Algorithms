#include "edit_distance.h"
#include <stdlib.h>
#include "unity.h"

void setUp(void){}
void tearDown(void){}


/*test elementi vuoti o nulli*/

void test_edit_distance_string_1_null(){
    char s2[]="aaaaaa";
    TEST_ASSERT(ric_edit_distance(NULL,s2)== ERROR_DISTACE);
}
void test_edit_distance_string_2_null(){
    char s1[]="aaaaaa";
    TEST_ASSERT(ric_edit_distance(s1,NULL)== ERROR_DISTACE);
}
void test_edit_distance_mem_string_1_null(){
    char s1[]="aaaaaa";
    TEST_ASSERT(dinamic_edit(s1,NULL,ERROR_DISTACE) == ERROR_DISTACE);
}
void test_edit_distance_mem_string_2_null(){
    char s2[]="aaaaaa";
    TEST_ASSERT(dinamic_edit(NULL,s2,ERROR_DISTACE)== ERROR_DISTACE);
}
void test_edit_distance_null(){
    TEST_ASSERT(ric_edit_distance(NULL,NULL)== ERROR_DISTACE);
}
void test_edit_distance_mem_null(){
    TEST_ASSERT(dinamic_edit(NULL,NULL,ERROR_DISTACE)== ERROR_DISTACE);
}
void test_edit_distance_string_1_empty(){
    char s1[]="";
    char s2[]="aa";
    TEST_ASSERT(ric_edit_distance(s1,s2) == (int)strlen(s2));
}
void test_edit_distance_string_2_empty(){
    char s2[]="";
    char s1[]="aa";
    TEST_ASSERT(ric_edit_distance(s1,s2) == (int)strlen(s1));
}
void test_edit_distance_mem_string_1_empty(){
    char s1[]="";
    char s2[]="aa";
    TEST_ASSERT(dinamic_edit(s1,s2,ERROR_DISTACE) == (int)strlen(s2));
}
void test_edit_distance_mem_string_2_empty(){
    char s2[]="";
    char s1[]="aa";
    TEST_ASSERT(dinamic_edit(s1,s2,ERROR_DISTACE) == (int)strlen(s1));
}

/*test sul calcolo corretto dell'edit tra due stringhe*/
void test_edit_distance_string_different(){
    char s1[]="bbbbb"; 
    char s2[]="aaaa";
    TEST_ASSERT(ric_edit_distance(s1,s2) == 9);
}
void test_edit_distance_mem_string_different(){
   
    char s1[]="bbbbb"; 
    char s2[]="aaaa";
    TEST_ASSERT(dinamic_edit(s1,s2,ERROR_DISTACE) == 9);
 
}
void test_edit_distance_string_equal(){
    char s1[]="bbb"; 
    char s2[]="bbb";
    TEST_ASSERT(ric_edit_distance(s1,s2) == 0);
}
void test_edit_distance_mem_string_equal(){
    char s1[]="bbb"; 
    char s2[]="bbb";
    TEST_ASSERT(dinamic_edit(s1,s2,ERROR_DISTACE) == 0);
}

void test_edit_distance_string_add(){
    char s1[]="b"; 
    char s2[]="bbb";
    TEST_ASSERT(ric_edit_distance(s1,s2) == 2);
}
void test_edit_distance_mem_string_add(){
    char s1[]="b"; 
    char s2[]="bbb";
    TEST_ASSERT(dinamic_edit(s1,s2,ERROR_DISTACE) == 2);
}
void test_edit_distance_string_remmove(){
    char s1[]="bbb"; 
    char s2[]="b";
    TEST_ASSERT(ric_edit_distance(s1,s2) == 2);
}
void test_edit_distance_mem_string_remmove(){
    char s1[]="bbb"; 
    char s2[]="b";
    TEST_ASSERT(dinamic_edit(s1,s2,ERROR_DISTACE) == 2);
}

void test_edit_distance_mem_string_word(){
    char s1[]="casa"; 
    char s2[]="casino";
    TEST_ASSERT(dinamic_edit(s1,s2,ERROR_DISTACE) == 4);
}
void test_edit_distance_string_word(){
    char s1[]="casa"; 
    char s2[]="casino";
    TEST_ASSERT(dinamic_edit(s1,s2,ERROR_DISTACE) == 4);
}


int main(void)
    {
    UNITY_BEGIN();
    RUN_TEST(test_edit_distance_string_1_null);
    RUN_TEST(test_edit_distance_string_2_null);
    RUN_TEST(test_edit_distance_mem_string_1_null);
    RUN_TEST(test_edit_distance_mem_string_2_null);
    RUN_TEST(test_edit_distance_null);
    RUN_TEST(test_edit_distance_mem_null);
    RUN_TEST(test_edit_distance_string_1_empty);
    RUN_TEST(test_edit_distance_string_2_empty);
    RUN_TEST(test_edit_distance_mem_string_1_empty);
    RUN_TEST(test_edit_distance_mem_string_2_empty);
    RUN_TEST(test_edit_distance_string_different);
    RUN_TEST(test_edit_distance_mem_string_different);
    RUN_TEST(test_edit_distance_string_equal);
    RUN_TEST(test_edit_distance_mem_string_equal);
    RUN_TEST(test_edit_distance_string_add);
    RUN_TEST(test_edit_distance_mem_string_add);    
    RUN_TEST(test_edit_distance_string_remmove);
    RUN_TEST(test_edit_distance_mem_string_remmove);
    RUN_TEST(test_edit_distance_mem_string_word);
    RUN_TEST(test_edit_distance_string_word);
    return UNITY_END();

    }