import random
import time
import matplotlib.pyplot as plt

# Sorting Algorithms Implementation with Counters

def selection_sort(arr):
    n = len(arr)
    comparisons = 0
    swaps = 0
    for i in range(n - 1):
        min_idx = i
        for j in range(i + 1, n):
            comparisons += 1
            if arr[j] < arr[min_idx]:
                min_idx = j
        if min_idx != i:
            swaps += 1
            arr[i], arr[min_idx] = arr[min_idx], arr[i]
    return arr, comparisons, swaps

def insertion_sort(arr):
    n = len(arr)
    comparisons = 0
    swaps = 0
    for i in range(1, n):
        key = arr[i]
        j = i - 1
        while True:
            if j < 0:
                break
            comparisons += 1
            if arr[j] <= key:
                break
            arr[j + 1] = arr[j]
            swaps += 1
            j -= 1
        arr[j + 1] = key
        swaps += 1
    return arr, comparisons, swaps

def bubble_sort(arr):
    n = len(arr)
    comparisons = 0
    swaps = 0
    for i in range(n):
        swapped = False
        for j in range(n - i - 1):
            comparisons += 1
            if arr[j] > arr[j + 1]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]
                swaps += 1
                swapped = True
        if not swapped:
            break
    return arr, comparisons, swaps

def quicksort(arr):
    comparisons = [0]
    swaps = [0]
    
    def partition(low, high):
        pivot = arr[high]
        i = low - 1
        for j in range(low, high):
            comparisons[0] += 1
            if arr[j] <= pivot:
                i += 1
                if i != j:
                    swaps[0] += 1
                    arr[i], arr[j] = arr[j], arr[i]
        if (i + 1) != high:
            swaps[0] += 1
            arr[i + 1], arr[high] = arr[high], arr[i + 1]
        return i + 1
    
    def quicksort_helper(low, high):
        if low < high:
            pi = partition(low, high)
            quicksort_helper(low, pi - 1)
            quicksort_helper(pi + 1, high)
    
    quicksort_helper(0, len(arr) - 1)
    return arr, comparisons[0], swaps[0]

# Generate random arrays
def generate_random_array(size):
    return [random.randint(0, size * 10) for _ in range(size)]

# Experiment setup
sizes = [100, 1000, 10000, 100000]
algorithms = {
    'Selection Sort': selection_sort,
    'Insertion Sort': insertion_sort,
    'Bubble Sort': bubble_sort,
    'Quicksort': quicksort
}

results = {algo: {'times': [], 'comparisons': [], 'swaps': []} for algo in algorithms}

# Run experiments
for size in sizes:
    print(f"Processing size {size}...")
    arr = generate_random_array(size)
    for algo_name in algorithms:
        print(f"  Running {algo_name}...")
        arr_copy = arr.copy()
        start_time = time.time()
        sorted_arr, comp, swp = algorithms[algo_name](arr_copy)
        end_time = time.time()
        time_ms = (end_time - start_time) * 1000  # Convert to milliseconds
        results[algo_name]['times'].append(time_ms)
        results[algo_name]['comparisons'].append(comp)
        results[algo_name]['swaps'].append(swp)

# Generate plots
def plot_metric(metric, title, ylabel, filename):
    plt.figure(figsize=(10, 6))
    for algo_name in algorithms:
        plt.plot(sizes, results[algo_name][metric], marker='o', label=algo_name)
    plt.xscale('log')
    plt.yscale('log')
    plt.xlabel('Input Size (log scale)')
    plt.ylabel(ylabel)
    plt.title(title)
    plt.legend()
    plt.grid(True)
    plt.savefig(filename)
    plt.close()

plot_metric('times', 'Execution Time Comparison', 'Time (ms, log scale)', 'time_comparison.png')
plot_metric('comparisons', 'Number of Comparisons', 'Comparisons (log scale)', 'comparison_count.png')
plot_metric('swaps', 'Number of Swaps', 'Swaps (log scale)', 'swap_count.png')