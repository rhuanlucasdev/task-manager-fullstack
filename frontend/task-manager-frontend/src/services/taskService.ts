const API_URL = 'http://localhost:8080/tasks'

/**
 * Busca todas as tarefas.
 */
export async function getTasks() {
  const response = await fetch(API_URL)
  return response.json()
}

/**
 * Cria uma nova tarefa.
 */
export async function createTask(title: string) {
  const response = await fetch(API_URL, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify({ title }),
  })
  return response.json()
}

/**
 * Deleta uma tarefa
 */
export async function deleteTask(id: number) {
  await fetch(`${API_URL}/${id}`, {
    method: 'DELETE',
  })
}

/**
 * Alterna status
 */
export async function toggleTask(id: number) {
  const response = await fetch(`${API_URL}/${id}`, {
    method: 'PATCH',
  })
  return response.json()
}
