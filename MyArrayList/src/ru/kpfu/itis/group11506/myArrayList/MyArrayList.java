package ru.kpfu.itis.group11506.myArrayList;

import java.util.*;

public class MyArrayList<E> implements List<E> {

    private Object[] elementData;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = new Object[DEFAULT_CAPACITY];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " +
                    initialCapacity);
        }
    }

    // Возвращает число элементов в этом списке.
    @Override
    public int size() {
        return size;
    }


    //  возарвщает true, если этот список не содержит элементов.
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // возвращает true, если этот список содержит указанный элемент.
    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int cursor = 0;

            @Override
            public boolean hasNext() {
                return size > cursor;
            }

            @Override
            public E next() {
                return get(cursor++);
            }
        };
    }

    // Возвращает массив, содержащий все элементы в этом списке в надлежащей последовательности
    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elementData, size);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    // Добавляет указанный элемент до конца этого списка.
    @Override
    public boolean add(E value) {
        if (size == elementData.length){
            growArray();
        }
        elementData[size] = value;
        size++;
        return true;
    }

    // увеличение массива
    private void growArray(){
        E[] newArray = (E[])new Integer[elementData.length * 2];
        System.arraycopy(elementData, 0, newArray, 0, size);
        elementData = newArray;
    }

    // Добавляет все элементы в указанном наборе до конца этого списка.
    @Override
    public boolean addAll(Collection<? extends E> c) {

        Object[] a = c.toArray();
        for (int i = 0; i < a.length; i++) {
            add((E) a[i]);
        }
        return true;
    }

    // Вставляет все элементы в указанном наборе в этот список, запускающийся в указанной позиции.
    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index is incorrect" + index);
        }
        Object[] a = c.toArray();
        for (int i = 0; i < a.length; i++) {
            add(index++, (E) a[i]);
        }
        return true;
    }

    // Удаляет первое возникновение указанного элемента от этого списка, если это присутствует.
    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (int index = 0; index < size; index++)
                if (elementData[index] == null) {
                    int value = size - index - 1;
                    if (value > 0) {
                        System.arraycopy(elementData, index + 1, elementData, index, value);
                    }
                    elementData[--size] = null;
                    return true;
                }
        } else {
            for (int index = 0; index < size; index++)
                if (o.equals(elementData[index])) {
                    int value = size - index - 1;
                    if (value > 0) {
                        System.arraycopy(elementData, index + 1, elementData, index, value);
                    }
                    elementData[--size] = null;
                    return true;
                }
        }
        return false;

    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    // Удаляет из этого списка все его элементы, которые содержатся в указанном наборе.
    @Override
    public boolean removeAll(Collection<?> c) {
        boolean changed = false;
        for (Object e : c) {
            if (contains(e)) {
                changed = true;
                remove(e);
            }
        }
        return changed;
    }

    // Сохраняет только элементы в этом списке, которые содержатся в указанном наборе.
    @Override
    public boolean retainAll(Collection<?> c) {
        Object[] a = c.toArray();
        boolean changed = false;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < size; j++) {
                if (get(j).equals(a[i])) {
                    remove(get(j));
                }
            }
        }
        return changed;
    }

    // Удаляет все элементы от этого списка.
    @Override
    public void clear() {
        for (int i = 0; i < size; i++)
            elementData[i] = null;
        size = 0;
    }

    private E elementData(int index) {
        return (E) elementData[index];
    }

    // Возвращает элемент в указанной позиции в этом списке.
    @Override
    public E get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + size);
        }
        return (E) elementData[index];
    }

    // Заменяет элемент в указанной позиции в этом списке с указанным элементом.
    @Override
    public E set(int index, E element) {
        try {
            E oldValue = elementData(index);
            elementData[index] = element;
            return oldValue;
        } catch (ClassCastException e) {
            throw new ClassCastException(e.getMessage());
        } catch (NullPointerException e) {
            throw new NullPointerException(e.getMessage());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException(e.getMessage());
        }
    }

    // добавление значения по индексу (происходит сдвиг всего массива)
    @Override
    public void add(int index, E value) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + size);
        }
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = value;
        size++;
    }

    @Override
    public E remove(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + size);
        }
        E oldValue = elementData(index);
        int value = size - index - 1;
        if (value > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, value);
        }
        elementData[--size] = null;
        return oldValue;
    }

    // удаление элемента по индексу
    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++)
                if (elementData[i] == null)
                    return i;
        } else {
            for (int i = 0; i < size; i++)
                if (o.equals(elementData[i]))
                    return i;
        }
        return -1;
    }

    // Возвращает индекс последнего вхождения указанного элемента в этом списке, или-1, если этот список не содержит элемент.
    @Override
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = size - 1; i >= 0; i--)
                if (elementData[i] == null)
                    return i;
        } else {
            for (int i = size - 1; i >= 0; i--)
                if (o.equals(elementData[i]))
                    return i;
        }
        return -1;
    }

    // Возвращает список iterator по элементам в этом списке (в надлежащей последовательности).
    @Override
    public ListIterator<E> listIterator() {
        return new ListIterator<E>() {
            int cursor = 0;

            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public E next() {
                return get(cursor++);
            }

            @Override
            public boolean hasPrevious() {
                return cursor != 0;
            }

            @Override
            public E previous() {
                return get(cursor--);
            }

            @Override
            public int nextIndex() {
                return cursor;
            }

            @Override
            public int previousIndex() {
                return cursor - 1;
            }

            @Override
            public void remove() {

            }

            @Override
            public void set(E e) {

            }

            @Override
            public void add(E e) {

            }
        };
    }

    // Возвращает список iterator по элементам в этом списке (в надлежащей последовательности), запускаясь в указанной позиции в списке.
    @Override
    public ListIterator<E> listIterator(final int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index: " + index);
        return new ListIterator<E>() {
            int cursor = index;

            @Override
            public boolean hasNext() {
                return cursor < size;
            }

            @Override
            public E next() {
                return get(cursor++);
            }

            @Override
            public boolean hasPrevious() {
                return cursor != 0;
            }

            @Override
            public E previous() {
                return get(cursor--);
            }

            @Override
            public int nextIndex() {
                return cursor;
            }

            @Override
            public int previousIndex() {
                return cursor - 1;
            }

            @Override
            public void remove() {

            }

            @Override
            public void set(E e) {

            }

            @Override
            public void add(E e) {

            }
        };
    }

    // Возвращает представление части этого списка между указанным fromIndex, включительно, и toIndex, монопольный.
    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        subListRangeCheck(fromIndex, toIndex, size);
        List<E> newElData = new ArrayList<E>();
        for (int i = fromIndex; i <= toIndex; i++) {

            newElData.add(elementData(i));
        }
        return newElData;
    }

    private static void subListRangeCheck(int fromIndex, int toIndex, int size) {
        if (fromIndex < 0)
            throw new IndexOutOfBoundsException("fromIndex = " + fromIndex);
        if (toIndex > size)
            throw new IndexOutOfBoundsException("toIndex = " + toIndex);
        if (fromIndex > toIndex)
            throw new IllegalArgumentException("fromIndex(" + fromIndex +
                    ") > toIndex(" + toIndex + ")");
    }

}
