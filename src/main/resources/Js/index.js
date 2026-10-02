// URL Base da sua API Spring Boot
const API_URL = 'http://localhost:8080/api/books';

// Armazena a lista global de livros carregados da API
let allBooksCache = [];

document.addEventListener('DOMContentLoaded', () => {
  loadTopBooks();
  loadAllBooks();

  document.getElementById('searchTitleInput').addEventListener('keyup', (e) => {
    if (e.key === 'Enter') {
      searchBookByTitle();
    }
  });
});

// 1. Mapeamento e Renderização do Grid Top 5 Livros do Ano
async function loadTopBooks() {
  const grid = document.getElementById('topBooksGrid');
  grid.innerHTML = '<p>Carregando destaques...</p>';

  try {
    const response = await fetch(API_URL);
    if (!response.ok) throw new Error('Erro ao buscar destaques.');

    const books = await response.json();
    const top5 = books.slice(0, 5);

    grid.innerHTML = '';
    if (top5.length === 0) {
      grid.innerHTML = '<p>Nenhum destaque cadastrado.</p>';
      return;
    }

    top5.forEach((book, index) => {
      const title = book.titulo || book.title || 'Título indisponível';
      const author = book.autor || book.author || 'Autor desconhecido';
      const publisher = book.editora || book.publisher || 'Editora N/A';
      const year = book.anoPublicacao || book.publicationYear || 'N/A';

      const card = document.createElement('div');
      card.className = 'book-card-top';
      card.innerHTML = `
        <div>
          <span class="rating-badge">★ TOP #${index + 1}</span>
          <h4>${title}</h4>
          <p><strong>Autor:</strong> ${author}</p>
        </div>
        <p style="margin-top: 10px; font-size: 0.8rem; color: #678;">
          ${publisher} • ${year}
        </p>
      `;
      grid.appendChild(card);
    });
  } catch (err) {
    grid.innerHTML = `<p style="color: var(--danger-color)">Não foi possível carregar os destaques.</p>`;
  }
}

// 2. GET /api/books - Carrega e Renderiza Todos os Livros
async function loadAllBooks() {
  const tbody = document.getElementById('booksTableBody');
  tbody.innerHTML = '<tr><td colspan="6">Carregando catálogo...</td></tr>';

  try {
    const response = await fetch(API_URL);
    if (!response.ok) throw new Error('Erro ao carregar o catálogo.');

    allBooksCache = await response.json();
    renderBooksTable(allBooksCache);
  } catch (err) {
    tbody.innerHTML = '<tr><td colspan="6" style="color: var(--danger-color)">Erro ao carregar livros. Verifique se a API está online.</td></tr>';
  }
}

// 3. Renderiza os dados no corpo da tabela (suporta DTOs em PT/EN)
function renderBooksTable(booksList) {
  const tbody = document.getElementById('booksTableBody');
  tbody.innerHTML = '';

  if (booksList.length === 0) {
    tbody.innerHTML = '<tr><td colspan="6">Nenhum livro encontrado.</td></tr>';
    return;
  }

  booksList.forEach(book => {
    const title = book.titulo || book.title || 'Sem Título';
    const author = book.autor || book.author || 'Sem Autor';
    const publisher = book.editora || book.publisher || 'N/A';
    const year = book.anoPublicacao || book.publicationYear || 'N/A';

    const row = document.createElement('tr');
    row.innerHTML = `
      <td>${book.id}</td>
      <td><strong>${title}</strong></td>
      <td>${author}</td>
      <td>${publisher}</td>
      <td>${year}</td>
      <td class="actions-cell">
        <button class="btn-danger" onclick="deleteBook(${book.id})">Excluir</button>
      </td>
    `;
    tbody.appendChild(row);
  });
}

// 4. Pesquisa Dinâmica de Livro por Nome/Título
function searchBookByTitle() {
  const searchTerm = document.getElementById('searchTitleInput').value.trim().toLowerCase();

  if (!searchTerm) {
    renderBooksTable(allBooksCache);
    return;
  }

  // Filtra pelo título no cache local (independente de estar salvo como 'titulo' ou 'title')
  const filteredBooks = allBooksCache.filter(book => {
    const bookTitle = (book.titulo || book.title || '').toLowerCase();
    return bookTitle.includes(searchTerm);
  });

  renderBooksTable(filteredBooks);
}

// 5. Limpa o Campo de Busca
function clearSearch() {
  document.getElementById('searchTitleInput').value = '';
  renderBooksTable(allBooksCache);
}

// 6. DELETE /api/books/{id} - Remover Livro do Catálogo
async function deleteBook(id) {
  if (!confirm(`Deseja realmente remover o livro ID #${id}?`)) return;

  try {
    const response = await fetch(`${API_URL}/${id}`, { method: 'DELETE' });
    if (!response.ok) throw new Error('Erro ao remover livro.');

    await loadAllBooks();
    await loadTopBooks();
  } catch (err) {
    alert(err.message);
  }
}