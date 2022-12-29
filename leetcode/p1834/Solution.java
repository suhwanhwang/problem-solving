class Solution {
    /*    0     1     2     3
tasks = [[1,2],[2,4],[3,2],[4,1]]
pq       1
index    4
time     6
cur      3
order    1
ans      0 2 3 1

    */
    private static class Task {
        int index;
        int enqueueTime;
        int processingTime;
        public Task(int index, int enqueueTime, int processingTime) {
            this.index = index;
            this.enqueueTime = enqueueTime;
            this.processingTime = processingTime;
        }
    }

    public int[] getOrder(int[][] tasks) {
        List<Task> taskList = new ArrayList<>();
        for (int i = 0; i < tasks.length; ++i) {
            taskList.add(new Task(i, tasks[i][0], tasks[i][1]));
        }
        Collections.sort(taskList, (a, b) -> {
            return a.enqueueTime - b.enqueueTime;
        });

        Queue<Integer> pq = new PriorityQueue<>((a, b) -> {
            if (taskList.get(a).processingTime == taskList.get(b).processingTime) {
                return taskList.get(a).index - taskList.get(b).index;
            }
            return taskList.get(a).processingTime - taskList.get(b).processingTime;
        });
        
        final int n = tasks.length;
        int[] ans = new int[n];
        
        int index = 0;
        int time = taskList.get(0).enqueueTime;
        int order = 0;

        while(index < n || !pq.isEmpty()) {
            while(index < n && time >= taskList.get(index).enqueueTime) {
                pq.offer(index);
                index++;
            }
            if (pq.isEmpty()) {
                time = taskList.get(index).enqueueTime;
                continue;
            }

            int curIndex = pq.poll();
            ans[order++] = taskList.get(curIndex).index;
            time += taskList.get(curIndex).processingTime;
        }
        return ans;
    }
}
