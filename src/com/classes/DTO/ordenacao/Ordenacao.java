package com.classes.DTO.ordenacao;

import java.util.List;

import com.classes.DTO.empresa.Matriz;

public class Ordenacao {
	public static List<Matriz> quickSort(List<Matriz> array, int left, int right) {
	    if (left < right) {
	        int p = partition(array, left, right);
	        quickSort(array, left, p);
	        quickSort(array, p + 1, right);
	    }
	    return array;
	}
   
   private static int partition(List<Matriz> array, int left, int right) {
	   	int meio = (left + right) / 2;
	    Matriz pivot = array.get(meio);
	    int i = left - 1;
	    int j = right + 1;
	    while (true) {
	        do {
	            i++;
	        } while (array.get(i).getQuantidade() < pivot.getQuantidade());

	        do {
	            j--;
	        } while (array.get(j).getQuantidade() > pivot.getQuantidade());

	        if (i >= j) {
	            return j;
	        }

	        int aux = array.get(i).getQuantidade();
	        String auxS = array.get(i).getNome();
	        array.get(i).setQuantidade(array.get(j).getQuantidade());
	        array.get(i).setNome(array.get(j).getNome());
	        array.get(j).setQuantidade(aux);
	        array.get(j).setNome(auxS);
	    }
   }
}
