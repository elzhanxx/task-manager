public class Main {

    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        Task task = new Task("задача 1", "описание 1");
        manager.createTask(task);

        Epic epic = new Epic("эпик 1", "описание 1");
        manager.createEpic(epic);

        Subtask subtask = new Subtask("подзадача 1", "описание 1", epic);
        manager.createSubtask(subtask);

        subtask.setStatus(TaskStatus.IN_PROGRESS);
        manager.updateSubtask(subtask);

        System.out.println("Статус эпика: " + epic.getStatus()); // Expected: IN_PROGRESS

        // TODO
        Task task1 = new Task("Сходить в магаз за хлебом", "Телефон не забыть");
        Task task2 = new Task("Погладить котят", "Каждого по отдельности");
        manager.createTask(task1);
        manager.createTask(task2);

        Epic epic1 = new Epic("Сдать кровь на донорство", "Сделать благородное дело");
        manager.createEpic(epic1);

        Subtask subtask1 = new Subtask("Взять удостоверение", "Удостоверение обязательно", epic1);
        Subtask subtask2 = new Subtask("Быть готовым морально", "Это тяжело", epic1);
        manager.createSubtask(subtask1);
        manager.createSubtask(subtask2);

        printTasks(manager);
        printEpics(manager);
        printSubtasks(manager);

        subtask1.setStatus(TaskStatus.DONE);
        manager.updateSubtask(subtask1);

        subtask2.setStatus(TaskStatus.IN_PROGRESS);
        manager.updateSubtask(subtask2);

        System.out.println("Статус эпика1 после обновлений: " + epic1.getStatus());

        epic1.setTitle("Что-то новое");
        subtask2.setStatus(TaskStatus.DONE);
        manager.updateSubtask(subtask2);
        System.out.println("\nСтатус эпика1 после обновлений: " + epic1.getStatus());
        System.out.println("\nНазвание эпика1 после обновления: " + epic1.getTitle() );

        manager.deleteTaskById(task1.getId());
        manager.deleteSubtaskById(subtask2.getId());
        manager.deleteEpicById(epic1.getId());
    }
    private static void printTasks(TaskManager manager) {
        System.out.println("Список всех задач:");
        for (Task task : manager.getAllTasks()) {
            System.out.println("\nID: " + task.getId() + task.getTitle() + "\n Описание: " + task.getDescription() + "\n Статус: " + task.getStatus());
        }
    }

    private static void printEpics(TaskManager manager) {
        System.out.println("\nСписок всех эпиков:");
        for (Epic epic : manager.getAllEpics()) {
            System.out.println("\nID: " + epic.getId() + "\n Название: " + epic.getTitle() + "\n Описание: " + epic.getDescription() + "\n Статус: " + epic.getStatus());
        }
    }

    private static void printSubtasks(TaskManager manager) {
        System.out.println("\nСписок всех подзадач:");
        for (Subtask subtask : manager.getAllSubtasks()) {
            System.out.println("\nID: " + subtask.getId() + "\n Название: " + subtask.getTitle() + "\n Описание: " + subtask.getDescription() + "\n Статус: " + subtask.getStatus() + "\n ID эпика: " + subtask.getEpic().getId());
        }
    }

}
