<main class="page shopping-cart-page">
    <section class="clean-block clean-cart dark">
        <div class="container">
            <div class="block-heading">
                <h2 class="text-info">Tabla de precios</h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc quam urna, dignissim nec auctor in, mattis vitae leo.</p>
            </div>
            <div class="content">
               	<h5 class="text-info">Parámetros de búsqueda</h5>
               	<form>
               		
              	</form>
            </div>
		    <div class="content">
                <div class="table-responsive">
					<table class="table">
						<thead>
							<tr>
								<th scope="col">Categoría</th>
								<th>Producto</th>
								<th>Unidad de medida</th>
								<g:each in="${mercados}" var="mercado">
									<th>${mercado}</th>
								</g:each>
								<th>Promedio nacional</th>
							</tr>
						</thead>
						<tbody>
							<g:each in="${datos}" var="categoria">
								<g:each in="${categoria.productos}" var="producto">
									<tr>
										<td>${categoria.categoria}</td>
										<td>${producto.producto}</td>
										<td>${producto.producto.unidadMedida}</td>
										<g:each in="${producto.mercados}" var="mercado">
											<td>${mercado.precio}</td>
										</g:each>
										<td><g:formatNumber number="${producto.promedio}" type="number" maxFractionDigits="2" /></td>
									</tr>
								</g:each>
							</g:each>
						</tbody>
					</table>
                </div>
            </div>
        </div>
    </section>
</main>

