#include "sort_test.h"
#include <stdlib.h>
#include "unity.h"
#define SIZE(a) (sizeof(a)/sizeof(*a))
 int compare_int(void *num1, void *num2){
    if(*(int*)num1>*(int*)num2)
        return 1;
    else if(*(int*)num1<*(int*)num2)
        return -1;
    else    
        return 0;
    }
 int compare_char(void *char1, void *char2){
    if(*(char*)char1>*(char*)char2)
        return 1;
    else if(*(char*)char1<*(char*)char2)
        return -1;
    else    
        return 0;
    }
void setUp(void){}
void tearDown(void){}

                            /*test bin search*/


/*essendo che il controllo degli edge cases sta nel metodo wrapper del bin search,
 lo unit testing sul bin search verrà fatto sul metodo wrapper solamente*/
void test_bin_search_null(){
    TEST_ASSERT(bin_search(NULL,NULL,NULL,0,0)== -1);
}
void test_bin_search_one_int_present(){
    int a[]={5};
    int elem=5;
    TEST_ASSERT(bin_search(&a,&elem,compare_int,sizeof(elem),SIZE(a))== 0);
}
void test_bin_search_one_int_absent_less_then(){
    int a[]={5};
    int elem=4;
    TEST_ASSERT(bin_search(&a,&elem,compare_int,sizeof(elem),SIZE(a))== 0);
}
void test_bin_search_one_int_absent_more_then(){
    int a[]={5};
    int elem=6;
    TEST_ASSERT(bin_search(&a,&elem,compare_int,sizeof(elem),SIZE(a))== 1);
}
void test_bin_search_all_equal_present(){
    int a[]={9,9,9,9};
    int elem=9;
    TEST_ASSERT(bin_search(&a,&elem,compare_int,sizeof(elem),SIZE(a))== 1);
}
void test_bin_search_all_equal_absent_less_then(){
    int a[]={9,9,9,9};
    int elem=-3;
    TEST_ASSERT(bin_search(&a,&elem,compare_int,sizeof(elem),SIZE(a))== 0);
}
void test_bin_search_all_equal_absent_more_then(){
    int a[]={9,9,9,9};
    int elem=24;
    TEST_ASSERT(bin_search(&a,&elem,compare_int,sizeof(elem),SIZE(a))== 4);
}
void test_bin_search_normal_ordered_array_present(){
    int a[]={-2,4,8,10,218};
    int elem=10;
    TEST_ASSERT(bin_search(&a,&elem,compare_int,sizeof(elem),SIZE(a))== 3);
}
void test_bin_search_normal_ordered_array_absent(){
    int a[]={-2,4,8,10};
    int elem=2;
    TEST_ASSERT(bin_search(&a,&elem,compare_int,sizeof(elem),SIZE(a))== 1);
}

void test_bin_search_normal_ordered_array_char_present(){
    char a[]={'a','f','g','z'};
    char elem='a';
    TEST_ASSERT(bin_search(&a,&elem,compare_char,sizeof(elem),SIZE(a))== 0);
}
void test_bin_search_normal_ordered_array_char_absent(){
    char a[]={'a','f','g','z'};
    char elem='e';
    TEST_ASSERT(bin_search(&a,&elem,compare_char,sizeof(elem),SIZE(a))== 1);
}

                    /*test insert last elem*/
//si assume che elem stia nell'ultima casella dell'array passata
void test_insert_last_elem_null(){ /*dovrebbe dare qualche tipo di errore, se tentasse di accedere all "array"*/
    insert_last_elem(NULL,sizeof(int),0,0);
}

void test_insert_last_elem_tot_length_one(){
    int a[]={4};
    int expected[]={4};
    insert_last_elem(a,sizeof(int),SIZE(a),0);
    TEST_ASSERT_EQUAL_INT_ARRAY(a, expected, SIZE(a));
}
void test_insert_last_elem_in_last_pos(){
    int a[]={-4,24,30,90,177};
    int expected[]={-4,24,30,90,177};
    insert_last_elem(a,sizeof(int),SIZE(a),4);
    TEST_ASSERT_EQUAL_INT_ARRAY(a, expected, SIZE(a));
}

void test_insert_last_elem_ordered_array(){
    int a[]={-4,24,30,90,2};
    int expected[]={-4,2,24,30,90};
    insert_last_elem(a,sizeof(int),SIZE(a),1);
    TEST_ASSERT_EQUAL_INT_ARRAY(a, expected, SIZE(a));
}
/*condizione che non dovrebbe mai succedere nel selection sort, ma come funzione indipendente sì*/
void test_insert_last_elem_unordered_array(){ 
    int a[]={25,-4,44,1,4};
    int expected[]={4,25,-4,44,1};
    insert_last_elem(a,sizeof(int),SIZE(a),0);
    TEST_ASSERT_EQUAL_INT_ARRAY(a, expected, SIZE(a));
}

void test_insert_last_elem_ordered_char_array(){
    char a[]={'b','e','f','y','k'};
    char expected[]={'b','e','f','k','y'};
    insert_last_elem(a,sizeof(char),SIZE(a),3);
    TEST_ASSERT_EQUAL_CHAR_ARRAY(a, expected, SIZE(a));
}
int main(void)
{
UNITY_BEGIN();
/*bin search*/

RUN_TEST(test_bin_search_null);
RUN_TEST(test_bin_search_one_int_present);
RUN_TEST(test_bin_search_one_int_absent_less_then);
RUN_TEST(test_bin_search_one_int_absent_more_then);
RUN_TEST(test_bin_search_all_equal_present);
RUN_TEST(test_bin_search_all_equal_absent_less_then);
RUN_TEST(test_bin_search_all_equal_absent_more_then);
RUN_TEST(test_bin_search_normal_ordered_array_present);
RUN_TEST(test_bin_search_normal_ordered_array_absent);
RUN_TEST(test_bin_search_normal_ordered_array_char_present);
RUN_TEST(test_bin_search_normal_ordered_array_char_absent);

/*insert last elem*/
RUN_TEST(test_insert_last_elem_null);
RUN_TEST(test_insert_last_elem_tot_length_one);
RUN_TEST(test_insert_last_elem_in_last_pos);
RUN_TEST(test_insert_last_elem_ordered_array);
RUN_TEST(test_insert_last_elem_unordered_array);
RUN_TEST(test_insert_last_elem_ordered_char_array);
return UNITY_END();
}