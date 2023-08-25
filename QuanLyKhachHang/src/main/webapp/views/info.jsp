<div class="container">
    <!-- edit form column -->
    <div class="col-lg-12 text-lg-center">
        <h2>Edit Info</h2>
    </div>
    <div class="col-lg-8 push-lg-4 personal-info">
        <form action="/customers/edit" method="post">
            <div class="form-group row">
                <label class="col-lg-3 col-form-label form-control-label">ID</label>
                <div class="col-lg-9">
                    <input class="form-control" name="id" type="number" value="${customer.id}" />
                </div>
            </div>
            <div class="form-group row">
                <label class="col-lg-3 col-form-label form-control-label">Name</label>
                <div class="col-lg-9">
                    <input class="form-control" name="name" type="text" value="${customer.name}" />
                </div>
            </div>
            <div class="form-group row">
                <label class="col-lg-3 col-form-label form-control-label">Email</label>
                <div class="col-lg-9">
                    <input class="form-control" name="email" type="text" value="${customer.email}" />
                </div>
            </div>
            <div class="form-group row">
                <label class="col-lg-3 col-form-label form-control-label">Address</label>
                <div class="col-lg-9">
                    <input class="form-control" name="address" type="text" value="${customer.address}" />
                </div>
            </div>
            <div class="form-group row">
                <label class="col-lg-3 col-form-label form-control-label"></label>
                <div class="col-lg-9">
                    <input type="reset" class="btn btn-secondary" value="Cancel" />
                    <input type="submit" class="btn btn-primary" value="Save Changes" />
                </div>
            </div>
        </form>
    </div>
</div>