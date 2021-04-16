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
void test_bin_search_arr_null(){
    int elem=4;
    TEST_ASSERT(bin_search(NULL,&elem,compare_int,sizeof(elem),0)== -1);
}
void test_bin_search_cmp_null(){
    int a[]={21,43,213,534};
    int elem=4;
    TEST_ASSERT(bin_search(a,&elem,NULL,sizeof(elem),SIZE(a))== -1);
}

void test_bin_search_elem_null(){
    int a[]={21,43,213,534};
    TEST_ASSERT(bin_search(a,NULL,compare_int, 0,SIZE(a))== -1);
}

void test_bin_search_one_int_present(){
    int a[]={5};
    int elem=5;
    TEST_ASSERT(bin_search(a,&elem,compare_int,sizeof(elem),SIZE(a))== 0);
}
void test_bin_search_one_int_absent_less_then(){
    int a[]={5};
    int elem=4;
    TEST_ASSERT(bin_search(a,&elem,compare_int,sizeof(elem),SIZE(a))== 0);
}
void test_bin_search_one_int_absent_more_then(){
    int a[]={5};
    int elem=6;
    TEST_ASSERT(bin_search(a,&elem,compare_int,sizeof(elem),SIZE(a))== 1);
}
void test_bin_search_all_equal_present(){
    int a[]={9,9,9,9};
    int elem=9;
    TEST_ASSERT(bin_search(a,&elem,compare_int,sizeof(elem),SIZE(a))== 1);
}
void test_bin_search_all_equal_absent_less_then(){
    int a[]={9,9,9,9};
    int elem=-3;
    TEST_ASSERT(bin_search(a,&elem,compare_int,sizeof(elem),SIZE(a))== 0);
}
void test_bin_search_all_equal_absent_more_then(){
    int a[]={9,9,9,9};
    int elem=24;
    TEST_ASSERT(bin_search(a,&elem,compare_int,sizeof(elem),SIZE(a))== 4);
}
void test_bin_search_normal_ordered_array_present(){
    int a[]={-2,4,8,10,218};
    int elem=10;
    TEST_ASSERT(bin_search(a,&elem,compare_int,sizeof(elem),SIZE(a))== 3);
}
void test_bin_search_normal_ordered_array_absent(){
    int a[]={-2,4,8,10};
    int elem=2;
    TEST_ASSERT(bin_search(a,&elem,compare_int,sizeof(elem),SIZE(a))== 1);
}

void test_bin_search_normal_ordered_array_char_present(){
    char a[]={'a','f','g','z'};
    char elem='a';
    TEST_ASSERT(bin_search(a,&elem,compare_char,sizeof(elem),SIZE(a))== 0);
}
void test_bin_search_normal_ordered_array_char_absent(){
    char a[]={'a','f','g','z'};
    char elem='e';
    TEST_ASSERT(bin_search(a,&elem,compare_char,sizeof(elem),SIZE(a))== 1);
}

void test_bin_search_ordered_array_from_offsetchar_present(){
    char a[]={'g','n','c','e','h','k','q'};
    char elem='e';
    TEST_ASSERT(bin_search(a+3,&elem,compare_char,sizeof(elem),SIZE(a))== 0);
}

void test_bin_search_ordered_array_from_offsetchar_absent(){
    char a[]={'g','n','c','e','h','k','q'};
    char elem='f';
    TEST_ASSERT(bin_search(a+3,&elem,compare_char,sizeof(elem),SIZE(a))== 1);
}
                    /*test insert last elem*/
//si assume che elem stia nell'ultima casella dell'array passata
void test_insert_last_elem_null(){ /*dovrebbe dare qualche tipo di errore, se tentasse di accedere all "array"*/
    int *a=NULL;
    insert_last_elem(a,sizeof(int),0,0);
    TEST_ASSERT(a==NULL);
}
void test_insert_last_elem_zero_elems(){ /*dovrebbe dare qualche tipo di errore, se tentasse di accedere all "array"*/
    int a[]={2,6,21,532};
    int expected[]={2,6,21,532};
    insert_last_elem(a,sizeof(int),0,0);
   TEST_ASSERT_EQUAL_INT_ARRAY( expected,a, SIZE(a) );
}

void test_insert_last_elem_tot_length_one(){
    int a[]={4};
    int expected[]={4};
    insert_last_elem(a,sizeof(int),SIZE(a),0);
    TEST_ASSERT_EQUAL_INT_ARRAY( expected,a, SIZE(a));
}
void test_insert_last_elem_in_last_pos(){
    int a[]={-4,24,30,90,177};
    int expected[]={-4,24,30,90,177};
    insert_last_elem(a,sizeof(int),SIZE(a),4);
    TEST_ASSERT_EQUAL_INT_ARRAY( expected,a, SIZE(a));
}

void test_insert_last_elem_ordered_array(){
    int a[]={-4,24,30,90,2};
    int expected[]={-4,2,24,30,90};
    insert_last_elem(a,sizeof(int),SIZE(a),1);
    TEST_ASSERT_EQUAL_INT_ARRAY( expected,a, SIZE(a));
}
/*condizione che non dovrebbe mai succedere nel selection sort, ma come funzione indipendente sì*/
void test_insert_last_elem_unordered_array(){ 
    int a[]={25,-4,44,1,4};
    int expected[]={4,25,-4,44,1};
    insert_last_elem(a,sizeof(int),SIZE(a),0);
    TEST_ASSERT_EQUAL_INT_ARRAY( expected,a, SIZE(a));
}

void test_insert_last_elem_ordered_char_array(){
    char a[]={'b','e','f','y','k'};
    char expected[]={'b','e','f','k','y'};
    insert_last_elem(a,sizeof(char),SIZE(a),3);
    TEST_ASSERT_EQUAL_CHAR_ARRAY( expected,a, SIZE(a));
}


void test_insert_last_elem_ordered_array_from_offset(){
    int a[]={-4,16,16,19,20,21,33,19};
    int expected[]={-4,16,16,19,19,20,21,33};
    insert_last_elem(a+3,sizeof(int),5,1);
    TEST_ASSERT_EQUAL_INT_ARRAY( expected,a, SIZE(a));
}

                 /*bin insertion sort*/

void test_insert_bin_sort_arr_null(){
    int *a=NULL;
    bin_insert_sort(a,compare_char,0,0); /*dovrebbe dare qualche tipo di errore, se tentasse di accedere all "array"*/
    TEST_ASSERT(a==NULL);
}
void test_insert_bin_sort_cmp_null(){
    int *a=NULL;
    bin_insert_sort(a,NULL,0,0); /*dovrebbe dare qualche tipo di errore, se tentasse di accedere alla "funzione"*/
    TEST_ASSERT(a==NULL);
}
void test_insert_bin_sort_one_elem(){
    char a[]={'c'};
    char expected[]={'c'};
    bin_insert_sort(a,compare_char,sizeof(*a),SIZE(a));
    TEST_ASSERT_EQUAL_CHAR_ARRAY(expected,a, SIZE(a));
}
void test_insert_bin_sort_ordered(){
    int a[]={-4,99,1027,2222,4321};
    int expected[]={-4,99,1027,2222,4321};
    bin_insert_sort(a,compare_int,sizeof(*a),SIZE(a));
    TEST_ASSERT_EQUAL_INT_ARRAY(expected,a, SIZE(a));
}
void test_insert_bin_sort_reverse_order(){
    int a[]={33,21,8,-11,-4};
    int expected[]={-11,-4,8,21,33};
    bin_insert_sort(a,compare_int,sizeof(*a),SIZE(a));
    TEST_ASSERT_EQUAL_INT_ARRAY(expected,a, SIZE(a));
}
void test_insert_bin_sort_repeat(){
    int a[]={69,12,12,-6,2,24,2,91,2};
    int expected[]={-6,2,2,2,12,12,24,69,91};
    bin_insert_sort(a,compare_int,sizeof(*a),SIZE(a));
    TEST_ASSERT_EQUAL_INT_ARRAY(expected,a, SIZE(a));
}
void test_insert_bin_sort_from_offset(){
    int a[]={22,65,12,-23,99,21,2,-23,44};
    int expected[]={22,65,12,-23,-23,2,21,44,99};
    bin_insert_sort(a+3,compare_int,sizeof(*a),SIZE(a));
    TEST_ASSERT_EQUAL_CHAR_ARRAY(expected,a, SIZE(a));
}
                                    
                                     /*merge*/
void test_merge_arr_null(){
    int *a=NULL;
    merge(a,compare_int,0,0,0,0); /*dovrebbe dare qualche tipo di errore, se tentasse di accedere all "array"*/
    TEST_ASSERT(a==NULL);
}

void test_merge_cmp_null(){
    char *a=NULL;
    merge(a,NULL,0,0,0,0); /*dovrebbe dare qualche tipo di errore, se tentasse di accedere alla "funzione"*/
    TEST_ASSERT(a==NULL);
}
void test_merge_bad_indexes(){
    int a[]={12,24,21,-2,5,22};
    int expected[]={12,24,21,-2,5,22};
    merge(a,compare_int,sizeof(*a),5,2,0);
    TEST_ASSERT_EQUAL_INT_ARRAY(expected,a, SIZE(a));
}
void test_merge_one_elem(){
    int a[]={12};
    int expected[]={12};
    merge(a,compare_int,sizeof(*a),0,0,0);
    TEST_ASSERT_EQUAL_INT_ARRAY(expected,a, SIZE(a));
}

void test_merge_two(){
    int a[]={12,-2};
    int expected[]={-2,12};
    merge(a,compare_int,sizeof(*a),0,0,1);
    TEST_ASSERT_EQUAL_INT_ARRAY(expected,a, SIZE(a));
}

void test_merge_same_arr(){
    int a[]={-44,4,21,80,-44,4,21,80};
    int expected[]={-44,-44,4,4,21,21,80,80};
    merge(a,compare_int,sizeof(*a),0,3,SIZE(a)-1);
    TEST_ASSERT_EQUAL_INT_ARRAY(expected,a, SIZE(a));
}

void test_merge_same_arr_one_repeated_elem(){
    int a[]={42,42,42,42,42};
    int expected[]={42,42,42,42,42};
    merge(a,compare_int,sizeof(*a),0,1,SIZE(a)-1);
    TEST_ASSERT_EQUAL_INT_ARRAY(expected,a, SIZE(a));
}

void test_merge_from_offset_until_end_arr(){
    int a[]={35,2,-54,55,259,512,1024,-2,2,2,99,160};
    int expected[]={35,2,-54,-2,2,2,55,99,160,259,512,1024};
    merge(a,compare_int,sizeof(*a),3,6,SIZE(a)-1);
    TEST_ASSERT_EQUAL_INT_ARRAY(expected,a, SIZE(a));
}
void test_merge_from_begining_until_offset(){
    int a[]={-2,2,2,99,160,55,259,512,1024,35,2,-54};
    int expected[]={-2,2,2,55,99,160,259,512,1024,35,2,-54};
    merge(a,compare_int,sizeof(*a),0,4,8);
    TEST_ASSERT_EQUAL_INT_ARRAY(expected,a, SIZE(a));
}
void test_merge_in_order(){
    int a[]={1,1,2,3,5,8,13,21,34};
    int expected[]={1,1,2,3,5,8,13,21,34};
     merge(a,compare_int,sizeof(*a),0,4,SIZE(a)-1);
    TEST_ASSERT_EQUAL_INT_ARRAY(expected,a, SIZE(a));
}

void test_merge_unbalanced_indexes(){ /*condizione che non dovrebbe succedere*/
    int a[]={-33,1,-250,-56,-12,3,23};
    int expected[]={-250,-56,-33,-12,1,3,23};
    merge(a,compare_int,sizeof(*a),0,1,SIZE(a)-1);
    TEST_ASSERT_EQUAL_INT_ARRAY(expected,a, SIZE(a));
}
void test_merge_in_char(){
    char a[]={12, 21, 30, -5,2,5};
    char expected[]={-5,2,5,12,21,30};
    merge(a,compare_char,sizeof(*a),0,2,SIZE(a)-1);
    TEST_ASSERT_EQUAL_CHAR_ARRAY(expected,a, SIZE(a));
}

int main(void)
{
UNITY_BEGIN();
/*bin search*/

RUN_TEST(test_bin_search_arr_null);
RUN_TEST(test_bin_search_cmp_null);
RUN_TEST(test_bin_search_elem_null);
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
RUN_TEST(test_bin_search_ordered_array_from_offsetchar_present);
RUN_TEST(test_bin_search_ordered_array_from_offsetchar_absent);

/*insert last elem*/
RUN_TEST(test_insert_last_elem_null);
RUN_TEST(test_insert_last_elem_zero_elems);
RUN_TEST(test_insert_last_elem_tot_length_one);
RUN_TEST(test_insert_last_elem_in_last_pos);
RUN_TEST(test_insert_last_elem_ordered_array);
RUN_TEST(test_insert_last_elem_unordered_array);
RUN_TEST(test_insert_last_elem_ordered_char_array);
RUN_TEST(test_insert_last_elem_ordered_array_from_offset);

/*bin insert sort*/
RUN_TEST(test_insert_bin_sort_arr_null);
RUN_TEST(test_insert_bin_sort_cmp_null);
RUN_TEST(test_insert_bin_sort_one_elem);
RUN_TEST(test_insert_bin_sort_ordered);
RUN_TEST(test_insert_bin_sort_reverse_order);
RUN_TEST(test_insert_bin_sort_repeat);
RUN_TEST(test_insert_bin_sort_from_offset);

/*merge*/

RUN_TEST(test_merge_arr_null);
RUN_TEST(test_merge_cmp_null);
RUN_TEST(test_merge_bad_indexes);
RUN_TEST(test_merge_one_elem);
RUN_TEST(test_merge_two);
RUN_TEST(test_merge_same_arr);
RUN_TEST(test_merge_same_arr_one_repeated_elem);
RUN_TEST(test_merge_from_offset_until_end_arr);
RUN_TEST(test_merge_from_begining_until_offset);
RUN_TEST(test_merge_in_order);
RUN_TEST(test_merge_unbalanced_indexes);
RUN_TEST(test_merge_in_char);
return UNITY_END();
}